package com.javanoise.repository;

import com.javanoise.model.Producer;
import jdk.Exported;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

public interface ProducerJpaRepository extends JpaRepository<Producer, Long> {
    @Override
    @RestResource(exported = false)
    void delete(Long id);

    @Override
    @RestResource(exported = false)
    void delete(Producer entity);
}
