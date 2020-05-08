package com.newsaggregator.api.service.v1;


import com.newsaggregator.api.dto.v1.News;

import java.util.List;

public interface NewsService {

    List<News> getNewsList();

    List<String> getCatigories();

    List<String> getResources();

    News getNewsByResource(String resource);
}
