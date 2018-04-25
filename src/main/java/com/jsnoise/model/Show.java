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

    private String title;

    @Column(length = 500000)
    private String description;

    private String mp3;

    @Temporal(TemporalType.TIMESTAMP)
    private Date publishDate;

    private String link;

    @ManyToOne(fetch = FetchType.LAZY)
    private Producer producer;
}
