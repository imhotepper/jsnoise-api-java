package com.jsnoise.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Producer {

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

    @NotEmpty
    private String name;

    @NotNull
    private String website;

    private String feedUrl;
    private boolean isBlocked;

    @OneToMany
    @JoinColumn(name = "producer_id")
    private List<Show> shows = new ArrayList<>();
}
