package com.jsnoise.service;


import com.jsnoise.dto.ProducerCounts;
import com.jsnoise.dto.ProducerListItem;
import com.jsnoise.model.Producer;
import com.jsnoise.model.Show;
import com.jsnoise.repository.ProducerJpaRepository;
import com.jsnoise.repository.ShowJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JsNoiseService {

    @Autowired
    private ProducerJpaRepository _producersRepo;

    @Autowired
    private ShowJpaRepository _showsRepo;

    @Autowired
    private FeedParserService _parserService;

    @Transactional
    public Producer createAndSaveShows(Producer producer){
        _producersRepo.saveAndFlush(producer);

        List<Show> shows = _parserService.getShows(producer.getFeedUrl());
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

        List<Show> possibleSows = _parserService.getShows(producer.getFeedUrl()).stream()
                .distinct()
                .collect(Collectors.toList());
        List<Show> shows = new ArrayList<>();

        for(Show s: possibleSows)
            if(_showsRepo.countByLinkAndTitle(s.getLink(), s.getTitle()) == 0) {
                s.setProducer(producer);
                shows.add(s);
            }

        List<Show> savedShows =  _showsRepo.save(shows);
        _showsRepo.flush();

        return savedShows.size();

    }

    public List<ProducerCounts> getAll(){
        return _producersRepo.getProducersCount();
    }
}
