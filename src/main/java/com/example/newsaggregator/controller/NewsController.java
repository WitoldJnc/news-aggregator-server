package com.example.newsaggregator.controller;

import com.example.newsaggregator.model.News;
import com.example.newsaggregator.model.NewsComponent;
import com.example.newsaggregator.model.NewsFeed;
import com.example.newsaggregator.model.NewsItem;
import com.example.newsaggregator.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping("/rss")
    public ResponseEntity<List<News>> getList() {
        try {
            return new ResponseEntity<>(newsService.getNewsList(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

//        List<News> news = new ArrayList<>();
//
//        News n = new News();
//        n.setResource("resource1");
//        NewsComponent component = new NewsComponent();
//        component.setStatus("ok");
//
//        NewsFeed feed = new NewsFeed();
//        feed.setDescription("resource 1 descr");
//        feed.setTitle("resourse 1 feed title");
//        feed.setUrl("resourse-1.ru");
//        component.setFeed(feed);
//        List<String> coron = Collections.singletonList("корон");
//        List<String> sport = Collections.singletonList("спорт");
//        List<String> inter = Collections.singletonList("интер");
//        List<String> sa = Collections.singletonList("сэмп");
//        List<String> wo = Collections.singletonList("ворлд");
//        List<NewsItem> items = new ArrayList<>();
//        items.add(new NewsItem("title", "date", "link", "guid", "descr 1", "cont 1", coron));
//        items.add(new NewsItem("title", "date", "link", "guid", "descr 2", "cont 2", coron));
//        items.add(new NewsItem("title", "date", "link", "guid", "descr 3", "cont 3", inter));
//        component.setItems(items);
//        n.setNews(component);
//
//
//        News n2 = new News();
//        n2.setResource("resource2");
//        NewsComponent component2 = new NewsComponent();
//        component2.setStatus("ok");
//
//        NewsFeed feed2 = new NewsFeed();
//        feed2.setDescription("resource 2 descr");
//        feed2.setTitle("resourse 2 feed title");
//        feed2.setUrl("resourse-2.ru");
//        component2.setFeed(feed2);
//        List<NewsItem> item2 = new ArrayList<>();
//        item2.add(new NewsItem("titl2e", "date", "link", "guid", "descr 1", "cont 1", sport));
//        item2.add(new NewsItem("title2", "date", "link", "guid", "descr 2", "cont 2", coron));
//        item2.add(new NewsItem("title2", "date", "link", "guid", "descr 3", "cont 3", inter));
//        component2.setItems(item2);
//        n2.setNews(component2);
//
//
//
//
//
//
//        News n3 = new News();
//        n3.setResource("resource3");
//        NewsComponent component3 = new NewsComponent();
//        component3.setStatus("ok");
//
//        NewsFeed feed3 = new NewsFeed();
//        feed3.setDescription("resource 3 descr");
//        feed3.setTitle("resourse 3 feed title");
//        feed3.setUrl("resourse-3.ru");
//        component3.setFeed(feed3);
//        List<NewsItem> item3 = new ArrayList<>();
//        item3.add(new NewsItem("titl2e", "date", "link", "guid", "descr 1", "cont 1", sa));
//        item3.add(new NewsItem("title2", "date", "link", "guid", "descr 2", "cont 2", wo));
//        item3.add(new NewsItem("title2", "date", "link", "guid", "descr 3", "cont 3", inter));
//        component3.setItems(item3);
//        n3.setNews(component3);
//
//        List<News> list = new ArrayList<News>(){{
//            add(n); add(n2); add(n3);
//        }};
//
//        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/catigories")
    public ResponseEntity<List<String>> getCatigories() {

        return new ResponseEntity<>(newsService.getCatigories(), HttpStatus.OK);
    }

    @GetMapping("/resources")
    public ResponseEntity<List<String>> getResourceList() {
        return new ResponseEntity<>(newsService.getResources(), HttpStatus.OK);
    }

    @GetMapping("/res/{resource}")
    public ResponseEntity<News> getByResouce(@PathVariable String resource) {
        if (newsService.getNewsByResource(resource) != null) {
            return new ResponseEntity<>(newsService.getNewsByResource(resource), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
