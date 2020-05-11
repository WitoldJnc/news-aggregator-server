package com.newsaggregator.web.impl.v1;

import com.google.gson.Gson;

import com.newsaggregator.web.dto.v1.*;
import com.newsaggregator.web.service.v1.NewsService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@PropertySource("classpath:application.yml")
public class NewsServiceImpl implements NewsService {

    @Autowired
    private Environment env;

    @Override
    public List<News> getNewsList() {

        final RestTemplate restTemplate = new RestTemplate();
        final String externalApi = "https://api.rss2json.com/v1/api.json?rss_url=";
        final String apiKey = env.getProperty("api.key");
        val rsses = Rss.getAll();
        val newsLists = new ArrayList<News>();

        rsses.forEach(x -> {
            val fetchNews = restTemplate.getForEntity(externalApi + x.getUrl() + "&api_key=" + apiKey, String.class);
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
