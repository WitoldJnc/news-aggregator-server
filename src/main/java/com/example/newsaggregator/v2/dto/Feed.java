package com.example.newsaggregator.v2.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Feed {
    String language;
    String title;
    String description;
    String link;
    Image image;
    String lastBuildDate;

    public Feed(String language, String title, String description, String link,
                String lastBuildDate) {
        this.language = language;
        this.title = title;
        this.description = description;
        this.link = link;
        this.lastBuildDate = lastBuildDate;
    }


}
