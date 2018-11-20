package com.jsnoise.job;


import com.jsnoise.service.JsNoiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Logger;

@Component
public class FeedUpdater {

    private Logger _logger =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @Autowired
    private JsNoiseService _service;

    @Scheduled(initialDelay = 1000, fixedRate = 2_160_000)
    public void update() {
         long updatedPodcasts =_service.updateProducerShows();
         _logger.info("Updated podcasts: " +  updatedPodcasts);
    }
}

