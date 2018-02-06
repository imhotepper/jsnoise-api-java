package com.javanoise.model;

import javax.persistence.*;
import java.util.Date;

@Entity
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


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMp3() {
        return mp3;
    }

    public void setMp3(String mp3) {
        this.mp3 = mp3;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }




    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}
