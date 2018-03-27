package com.jsnoise.controller;


import com.jsnoise.dto.ProducerListItem;
import com.jsnoise.dto.ShowListItem;
import com.jsnoise.model.Producer;
import com.jsnoise.repository.ShowJpaRepository;
import com.jsnoise.service.JsNoiseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class ProducerController {

    private JsNoiseService _service;
    private final ShowJpaRepository _repo;

    public ProducerController(JsNoiseService _service, ShowJpaRepository repo) {
        this._service = _service;
        _repo = repo;
    }

    @RequestMapping(value = "/api/producers", method = RequestMethod.POST)
    public String registerProducer(@RequestBody Producer producer){
      _service.createAndSaveShows(producer);
      return producer.getName();
    }
    @RequestMapping(value = "/api/producers", method = RequestMethod.GET)
    public List<ProducerListItem> getAll(){
        return _service.getAll();
    }
    @RequestMapping(value = "/api/producers/{id}/shows")
    public Page<ShowListItem> get(@PathVariable Long id, @RequestParam( "page" ) int page, @RequestParam( name = "size", defaultValue = "20") int size){
        Pageable pg  = new PageRequest(page, size);
        return _repo.findShowsByProducerId(id,pg);
    }

    @RequestMapping(value = "/api/producers/update", method = RequestMethod.GET)
    public Long updateShows(){
        return _service.updateProducerShows();
    }
}
