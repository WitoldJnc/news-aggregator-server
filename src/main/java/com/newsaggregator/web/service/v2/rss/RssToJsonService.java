package com.newsaggregator.web.service.v2.rss;


import com.newsaggregator.web.dto.v2.rss.Rss;
import org.springframework.http.ResponseEntity;

public interface RssToJsonService {

    ResponseEntity<Rss> convertXml(String url);

    ResponseEntity<Rss> getRssAsPojo(String url);

    String formattingXml(String xml);

    boolean isRssFeed(String body);

}
