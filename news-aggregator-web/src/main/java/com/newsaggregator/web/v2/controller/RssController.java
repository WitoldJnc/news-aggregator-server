package com.newsaggregator.web.v2.controller;

import com.newsaggregator.api.dto.v2.RssChannelDTO;
import com.newsaggregator.api.dto.v2.rss.Rss;
import com.newsaggregator.api.service.v2.RssChannelRepoCustom;
import com.newsaggregator.api.service.v2.rss.RssToJsonService;
import com.newsaggregator.api.service.v2.vk.VkApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2/")
public class RssController {

    @Autowired
    private RssChannelRepoCustom channelRepoCustom;

    @Autowired
    private RssToJsonService rssToJsonService;

    @Autowired
    private VkApiService vkApiService;

    @GetMapping("/channels")
    public ResponseEntity<List<RssChannelDTO>> getAllChannels() {
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(channelRepoCustom.getAllRss());
    }


    @GetMapping("/rss")
    public ResponseEntity<Rss> geByRssUrl(@RequestParam("url") String url){
        return url.contains("vk.com")
                ? vkApiService.getVkFeed(url)
                : rssToJsonService.getRssAsPojo(url);

    }
}
