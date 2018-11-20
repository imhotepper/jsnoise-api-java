package com.jsnoise.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Show {

    @Id
    @GeneratedValue
    private long id;

    @Column(length = 500000)
    private String description;

    private String title;
    private String mp3;
    private String link;

    @Temporal(TemporalType.TIMESTAMP)
    private Date publishDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Producer producer;
}
