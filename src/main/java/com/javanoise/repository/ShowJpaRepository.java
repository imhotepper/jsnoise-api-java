package com.javanoise.repository;

import com.javanoise.dto.ShowListItem;
import com.javanoise.model.Show;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ShowJpaRepository extends JpaRepository<Show,Long> {
    Show findByLink(String link);

    @Query("select new com.javanoise.dto.ShowListItem(s.id, p.id, s.title, s.description, s.mp3, p.name, s.publishDate) from Show s inner join s.producer p where LOWER( s.title) like LOWER(:q) or LOWER( s.description) like LOWER(:q)    ")
    Page<ShowListItem> findByContains(@Param("q") String q, Pageable pageable);
    //
    @Query("select new com.javanoise.dto.ShowListItem(s.id, p.id, s.title, s.description, s.mp3, p.name, s.publishDate) from Show s inner join s.producer p ")
    Page<ShowListItem> findAllShows(  Pageable pageable);

    @Query("select new com.javanoise.dto.ShowListItem(s.id, p.id,s.title, s.description, s.mp3, p.name, s.publishDate) from Show s inner join s.producer p where s.id = :id ")
    ShowListItem findShowById(@Param("id") long id);

    @Query("select new com.javanoise.dto.ShowListItem(s.id, p.id,s.title, s.description, s.mp3, p.name, s.publishDate) from Show s inner join s.producer p where p.id = :id ")
    Page<ShowListItem> findShowsByProducerId(@Param("id") long id, Pageable pageable);



}
