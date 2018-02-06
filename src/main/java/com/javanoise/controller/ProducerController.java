package com.javanoise.controller;


import com.javanoise.model.Producer;
import com.javanoise.service.JavaNoiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProducerController {

    @Autowired
    private JavaNoiseService _service;


    @RequestMapping(value = "/api/producers", method = RequestMethod.POST)
    public String registerProducer(@RequestBody Producer producer){
      _service.createAndSaveShows(producer);
      return producer.getName();
    }

    @RequestMapping(value = "/api/producers/update", method = RequestMethod.GET)
    public Long updateShows(){
        return _service.updateProducerShows();
    }
}
