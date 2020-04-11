package com.example.newsaggregator.v1.controller;

import com.example.newsaggregator.v1.model.News;
import com.example.newsaggregator.v1.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
