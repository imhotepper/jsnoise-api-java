package com.jsnoise.service;

import com.jsnoise.model.Show;
import com.rometools.rome.feed.synd.SyndEnclosure;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
class FeedParserService {

    List<Show> getShows(String url){
        List<Show> shows = new ArrayList<>();

        try {

            URL feedUrl = new URL(url);

            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedUrl));

            List<SyndEntry> entries = feed.getEntries();


            Show item;
            List<SyndEnclosure> enclosures;
            String mp3;

            for (SyndEntry e : entries) {
                item = new Show();
                item.setTitle(e.getTitle());
                item.setLink( e.getLink());
                item.setPublishDate(e.getPublishedDate());
                 item.setDescription(e.getDescription().getValue());
                 enclosures= e.getEnclosures();
                if (enclosures.size() >0){
                     mp3= enclosures.get(0).getUrl();
                    if (mp3.contains("mp3"))
                        mp3 = mp3.substring(0,3+mp3.indexOf("mp3"));

                    item.setMp3( mp3);
                    shows.add(item);
                }
            }

        }catch (Exception exp){
            exp.printStackTrace();
        }

        return shows;
    }
}
