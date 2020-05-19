package com.newsaggregator.web.controller.v2;

import com.newsaggregator.web.dto.v2.RssChannelDTO;
import com.newsaggregator.web.dto.v2.rss.Rss;
import com.newsaggregator.web.model.v2.RssCategory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v2/")
public class RssController extends BaseController {


    @GetMapping("/channels")
    public ResponseEntity<List<RssChannelDTO>> getAllChannels() {
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(channelRepoCustom.getAllRss());
    }


    @GetMapping("/rss")
    public ResponseEntity<Rss> geByRssUrl(@RequestParam("url") String url) {
        return url.contains("vk.com")
                ? vkApiService.getVkFeed(url)
                : rssToJsonService.getRssAsPojo(url);

    }

    @GetMapping("/categories")
    public ResponseEntity<List<RssCategory>> getCatigories() {
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(categoryRepo.findAll().stream()
                        .sorted(Comparator.comparing(RssCategory::getName))
                        .collect(Collectors.toList()));
    }
}
