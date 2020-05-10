package com.newsaggregator.web.dto.v2.rss;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Feed {
    private String language;
    private String title;
    private String description;
    private String link;
    private Image image;
    private String lastBuildDate;

    public Feed(String language, String title, String description, String link,
                String lastBuildDate) {
        this.language = language;
        this.title = title;
        this.description = description;
        this.link = link;
        this.lastBuildDate = lastBuildDate;
    }


}
