package com.javanoise.controller;


import com.javanoise.dto.ShowListItem;
import com.javanoise.repository.ShowJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8081")
public class ShowsController {

    @Autowired
    private ShowJpaRepository _repository;

    @RequestMapping( value = "/api/showslist", method = RequestMethod.GET )
    //@GetMapping
    public Page<ShowListItem> showslist(@RequestParam( "page" ) int page, @RequestParam( name = "size", defaultValue = "20") int size,@RequestParam( name="q", defaultValue = "",required = false) String q){
        Sort sort = new Sort(Sort.Direction.DESC,"publishDate");
        Pageable pg  = new PageRequest(page, size, sort);

        Page<ShowListItem> sh;
        if (q.isEmpty()) sh = _repository.findAllShows(pg);
        else {
            q ="%"+q+"%";
            sh = _repository.findByContains(q,pg);
        }
        return sh;
      //  _repository.findByTitleOrDescription()
    }

    @RequestMapping(value = "/api/shows/{id}", method = RequestMethod.GET)
    public ShowListItem get(@PathVariable Long id){
        return _repository.findShowById(id);
    }
}
