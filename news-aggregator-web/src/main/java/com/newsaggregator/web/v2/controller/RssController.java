package com.newsaggregator.web.v2.controller;

import com.newsaggregator.api.dto.v2.RssChannelDTO;
import com.newsaggregator.api.service.v2.RssChannelRepoCustom;
import com.newsaggregator.api.service.v2.VkApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2/")
public class RssController {

    @Autowired
    private RssChannelRepoCustom channelRepoCustom;

    @Autowired
    private VkApiService vkApiService;

    @GetMapping("/channels")
    public ResponseEntity<List<RssChannelDTO>> getAllChannels() {
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(channelRepoCustom.getAllRss());
    }

    @GetMapping("/vk")
    public void getVk() {
        vkApiService.get("https://vk.com/ru2ch");
    }

}
