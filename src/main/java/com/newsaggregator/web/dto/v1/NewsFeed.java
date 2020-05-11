package com.newsaggregator.web.dto.v1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsFeed {
    private String url;
    private String title;
    private String description;
    private String image;
}
