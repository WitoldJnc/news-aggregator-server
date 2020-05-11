package com.newsaggregator.web.dto.v2.rss;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Channel {
    private Feed feed;
    private List<Item> items;
}
