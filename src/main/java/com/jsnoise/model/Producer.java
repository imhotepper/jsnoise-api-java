package com.jsnoise.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Producer {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFeedUrl() {
        return feedUrl;
    }

    public void setFeedUrl(String feedUrl) {
        this.feedUrl = feedUrl;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public Producer(Long id, String name, String website, String feedUrl, boolean isBlocked) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.feedUrl = feedUrl;
        this.isBlocked = isBlocked;
    }

    public Producer(){};

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String website;

    private String feedUrl;

    private boolean isBlocked;

    @OneToMany
    @JoinColumn(name = "producer_id")
    private List<Show> shows = new ArrayList<>();


}
