package com.example.newsaggregator.controller;

import com.example.newsaggregator.model.News;
import com.example.newsaggregator.model.NewsComponent;
import com.google.gson.Gson;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NewsController {

    @GetMapping("/rss")
    public List<News> getList() {
        final RestTemplate restTemplate = new RestTemplate();
        final String externalApi = "https://api.rss2json.com/v1/api.json?rss_url=";
        String rssUrl = "https://lenta.ru/rss";

        val news = restTemplate.getForEntity(externalApi + rssUrl, String.class);
        final String newsBody = news.getBody();
        NewsComponent news1 = new Gson().fromJson(newsBody, NewsComponent.class);

        List<News> newsLists = new ArrayList<>();
        News list = new News();
        list.setNews(news1);
        list.setResource(news1.getFeed().getTitle());
        newsLists.add(list);

        return newsLists;

    }
}
