package com.example.newsaggregator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsComponent {
    private String status;
    private NewsFeed feed;
    private List<NewsItem> items;
}
