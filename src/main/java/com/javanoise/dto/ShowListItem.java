package com.javanoise.dto;

import java.util.Date;

public class ShowListItem {



    public ShowListItem(long id, long producerId, String title, String description, String mp3, String producerName, Date pubDate) {
        this.id = id;
        this.producerId = producerId;
        this.title = title;
        this.description = description;
        this.mp3 = mp3;
        this.producerName = producerName;
        this.pubDate = pubDate;
    }
    long id;

    public long getProducerId() {
        return producerId;
    }

    long producerId;
    String title;
    String description;
    String mp3;
    String producerName;
    Date pubDate;

    public long getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getMp3() {
        return mp3;
    }

    public String getProducerName() {
        return producerName;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public ShowListItem(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
