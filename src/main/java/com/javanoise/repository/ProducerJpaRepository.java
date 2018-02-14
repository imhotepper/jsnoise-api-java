package com.javanoise.repository;

import com.javanoise.model.Producer;
import jdk.Exported;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducerJpaRepository extends JpaRepository<Producer, Long> {
}
