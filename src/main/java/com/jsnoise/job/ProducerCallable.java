package com.jsnoise.job;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.logging.Logger;

import com.jsnoise.model.*;

import lombok.extern.java.Log;

import  com.jsnoise.service.FeedParserService;


@Log
public class ProducerCallable implements Callable<List<Show>>{

    Producer _p;

    private FeedParserService _service;

    Logger _log = Logger.getLogger(ProducerCallable.class.getName());

    public ProducerCallable(Producer p, FeedParserService feedService){ _p = p;_service = feedService;}

    public List<Show> call() throws Exception{
        _log.info(Thread.currentThread().getName() + " - Running feed updates for: " + _p.getName() );
        
        List<Show> shows = _service.getShows(_p.getFeedUrl());
        _p.setShows(shows);

        for(Show s: shows)s.setProducer(_p);

        return shows;

    }

}