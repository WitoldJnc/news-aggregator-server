package com.example.newsaggregator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsItem {
    private String title;
    private String pubDate;
    private String link;
    private String guid;
    private String description;
    private String content;
    private List<String> categories;
}
