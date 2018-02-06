package com.javanoise.service;


import com.javanoise.model.Producer;
import com.javanoise.model.Show;
import com.javanoise.repository.ProducerJpaRepository;
import com.javanoise.repository.ShowJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class JavaNoiseService {

    @Autowired
    private ProducerJpaRepository _producersRepo;

    @Autowired
    private ShowJpaRepository _showsRepo;

    @Autowired FeedParserService _parserService;

    @Transactional
    public Producer createAndSaveShows(Producer producer){
        _producersRepo.saveAndFlush(producer);

        List<Show> shows = _parserService.getShows(producer.getFeedUrl());
        System.out.println("Shows loaded: " + shows.size());
        producer.setShows(shows);

        for(Show s: shows)s.setProducer(producer);

        _showsRepo.save(shows);
        _showsRepo.flush();

        return producer;
    }

    public Long updateProducerShows(){
        List<Producer> producers =  _producersRepo.findAll();

        Long count = 0L;
        for(Producer p : producers)
            count += updateShows(p);

        return  count;
    }

    @Transactional
    private Integer updateShows(Producer producer){

        List<Show> possibleSows = _parserService.getShows(producer.getFeedUrl());
        List<Show> shows = new ArrayList<>();

        for(Show s: possibleSows)
            if(_showsRepo.findByLink(s.getLink()) == null) {
                s.setProducer(producer);
                shows.add(s);
            }

      List<Show> savedShows =  _showsRepo.save(shows);
        _showsRepo.flush();

        return savedShows.size();

    }
}
