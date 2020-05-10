package com.newsaggregator.web.dto.v2.rss;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
    private String guid;
    private String title;
    private String link;
    private String description;
    private String pubDate;
    private List<String> enclosure;
    private List<String> category;

}
