package com.javanoise.repository;

import com.javanoise.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "http://localhost:8081")
@RepositoryRestResource(collectionResourceRel = "shows", path = "shows")
public interface ShowJpaRepository extends JpaRepository<Show,Long> {
    Show findByLink(String link);
}
