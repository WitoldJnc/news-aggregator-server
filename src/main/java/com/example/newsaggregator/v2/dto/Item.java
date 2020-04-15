package com.example.newsaggregator.v2.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Item {
    String guid;
    String title;
    String link;
    String description;
    String pubDate;
    List<String> enclosure;
    List<String> category;
}
