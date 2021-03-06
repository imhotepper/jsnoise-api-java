package com.jsnoise.repository;

import com.jsnoise.dto.ProducerCounts;
import com.jsnoise.dto.ProducerListItem;
import com.jsnoise.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProducerJpaRepository
        extends JpaRepository<Producer, Long> {
    @Query("select new com.jsnoise.dto.ProducerListItem" +
            "(p.id, p.name,  p.website,  p.isBlocked) " +
            " FROM Producer p")
    public List<ProducerListItem> getProducers();

    @Query("select new com.jsnoise.dto.ProducerCounts" +
            "(p.id, p.name, count(s))  " +
            "FROM Show s  " +
            "join s.producer p " +
            "group by p.id " +
            "order by count(s) desc ")
    public List<ProducerCounts> getProducersCount();
}
