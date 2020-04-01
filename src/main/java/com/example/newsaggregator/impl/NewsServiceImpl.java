package com.example.newsaggregator.impl;

import com.example.newsaggregator.model.News;
import com.example.newsaggregator.model.NewsComponent;
import com.example.newsaggregator.model.NewsItem;
import com.example.newsaggregator.model.Rss;
import com.example.newsaggregator.service.NewsService;
import com.google.gson.Gson;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsServiceImpl implements NewsService {

    @Override
    public List<News> getNewsList() {

        final RestTemplate restTemplate = new RestTemplate();
        final String externalApi = "https://api.rss2json.com/v1/api.json?rss_url=";

        val rsses = Rss.getAll();
        val newsLists = new ArrayList<News>();

        rsses.forEach(x -> {
            val fetchNews = restTemplate.getForEntity(externalApi + x.getUrl(), String.class);
            newsLists.add(new News(x.getResource(), new Gson().fromJson(fetchNews.getBody(), NewsComponent.class)));
        });


        return newsLists;
    }

    @Override
    public List<String> getCatigories() {
        return getNewsList().stream()
                .map(x -> x.getNews().getItems().stream()
                        .map(NewsItem::getCategories)
                        .collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList()).stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

    }

    @Override
    public List<String> getResources() {
        return getNewsList().stream()
                .map(News::getResource)
                .collect(Collectors.toList());
    }

    @Override
    public News getNewsByResource(String resource) {
        News news = null;
        for(News n : getNewsList()){
            if(n.getResource().equals(resource)) {
                news = n;
            }
        }
        return news;
    }
}
