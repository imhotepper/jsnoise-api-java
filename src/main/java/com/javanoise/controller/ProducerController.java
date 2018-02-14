package com.javanoise.controller;


import com.javanoise.dto.ShowListItem;
import com.javanoise.model.Producer;
import com.javanoise.repository.ProducerJpaRepository;
import com.javanoise.repository.ShowJpaRepository;
import com.javanoise.service.JavaNoiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class ProducerController {

    private JavaNoiseService _service;
    private final ShowJpaRepository _repo;

    public ProducerController(JavaNoiseService _service, ShowJpaRepository repo) {
        this._service = _service;
        _repo = repo;
    }

    @RequestMapping(value = "/api/producers", method = RequestMethod.POST)
    public String registerProducer(@RequestBody Producer producer){
      _service.createAndSaveShows(producer);
      return producer.getName();
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
