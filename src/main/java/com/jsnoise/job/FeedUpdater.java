package com.jsnoise.job;

import com.jsnoise.model.*;
import com.jsnoise.repository.*;
import com.jsnoise.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Logger;

@Component
public class FeedUpdater {

    private Logger _logger =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @Autowired
    private JsNoiseService _service;

    @Autowired
    private ProducerJpaRepository _producersRepo;


    @Autowired
    private ShowJpaRepository _showsRepo;

    @Autowired
    private FeedParserService _feedService;


    // @Scheduled(initialDelay = 1000, fixedRate = 2_160_000)
    // public void update() {
    //      long updatedPodcasts =_service.updateProducerShows();
    //      _logger.info("Updated podcasts: " +  updatedPodcasts);
    // }


    @Scheduled(initialDelay = 1000, fixedRate = 2_160_000)
    public void updateWithFeatures() {
        _logger.info("Starting parallel shows updater!");
        ExecutorService executor = Executors.newFixedThreadPool(5);
        //create a list to hold the Future object associated with Callable
        List<Future<List<Show>>> list = new ArrayList<Future<List<Show>>>();
        
        Long allShowsInitial = _showsRepo.count();
        //Create MyCallable instance
        for(Producer p : _producersRepo.findAll()){
        
            //submit Callable tasks to be executed by thread pool
            Future<List<Show>> future = executor.submit(new ProducerCallable(p,_feedService));
            //add Future to the list, we can get return value using Future
            list.add(future);
        }
        for(Future<List<Show>> feature : list){
            try {
                //print the return value of Future, notice the output delay in console
                // because Future.get() waits for task to get completed
                    List<Show> shows = feature.get();

                //TODO: save them to db?
                _showsRepo.save(shows);
                _showsRepo.flush();

                System.out.println(new Date()+ ": updated shows :" );
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        //shut down the executor service now
        executor.shutdown();
        Long updatedPodcasts = _showsRepo.count() -  allShowsInitial;
         _logger.info("Updated podcasts: " +  updatedPodcasts);
    }
}

