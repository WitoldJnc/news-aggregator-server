package com.example.newsaggregator.v1.service;


import com.example.newsaggregator.v1.model.News;

import java.util.List;

public interface NewsService {

    List<News> getNewsList();

    List<String> getCatigories();

    List<String> getResources();

    News getNewsByResource(String resource);
}
