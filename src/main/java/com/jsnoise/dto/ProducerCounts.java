package com.jsnoise.dto;

import lombok.Data;

@Data
public class ProducerCounts {
    private long id;
    private String name;
    private long count;

    public ProducerCounts(long id, String producerName, long count) {
        this.id = id;
        this.name = producerName;
        this.count = count;
    }
}
