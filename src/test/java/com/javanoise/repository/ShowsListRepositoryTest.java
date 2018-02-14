package com.javanoise.repository;

import com.javanoise.dto.ShowListItem;
import com.javanoise.model.Show;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShowsListRepositoryTest {

    @Autowired
    ShowJpaRepository _repo;

    @Test
    public void findByTitleOrDescription() {
        String q1 = "DeMarco";
        String q ="%"+ q1 +"%";
        Page<ShowListItem> items = _repo.findByContains( q, new PageRequest(0,10));
       // Page<ShowListItem> items = _repo.findByContains( q, new PageRequest(0,10));
        Assert.assertNotNull(items);
        Assert.assertTrue(items.getContent().size() > 0);
        String title = items.getContent().get(0).getTitle();
        Assert.assertTrue( title.toLowerCase().contains(q1.toLowerCase()));
    }


    @Test
    public void findByShows() {
        Page<ShowListItem> items = _repo.findAllShows(new PageRequest(0,10));
        Assert.assertNotNull(items);
    }
}