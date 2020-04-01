package com.example.newsaggregator.service;


import com.example.newsaggregator.model.News;

import java.util.List;

public interface NewsService {

    List<News> getNewsList();

    List<String> getCatigories();

    List<String> getResources();

    News getNewsByResource(String resource);
}
