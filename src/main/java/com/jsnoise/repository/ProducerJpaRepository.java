package com.jsnoise.repository;

import com.jsnoise.dto.ProducerListItem;
import com.jsnoise.model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProducerJpaRepository extends JpaRepository<Producer, Long> {
    @Query("select new com.jsnoise.dto.ProducerListItem(p.id, p.name,  p.website, p.feedUrl, p.isBlocked)  FROM Producer p")
    public List<ProducerListItem> getProducers();
}
