package com.example.newsaggregator.impl;

import com.example.newsaggregator.model.News;
import com.example.newsaggregator.service.NewsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Override
    public List<News> getNewsList() {
        return null;
    }
}
