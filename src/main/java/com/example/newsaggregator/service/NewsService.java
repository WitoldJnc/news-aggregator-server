package com.example.newsaggregator.service;


import com.example.newsaggregator.model.News;

import java.util.List;

public interface NewsService {

    List<News> getNewsList();
}
