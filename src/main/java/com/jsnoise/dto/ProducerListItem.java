package com.jsnoise.dto;

public class ProducerListItem {
    private Long id;
    private String name;

    public ProducerListItem(Long id, String name, String website,  boolean isBlocked) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.isBlocked = isBlocked;
    }

    private String website;
    private boolean isBlocked;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWebsite() {
        return website;
    }


    public boolean isBlocked() {
        return isBlocked;
    }


}
