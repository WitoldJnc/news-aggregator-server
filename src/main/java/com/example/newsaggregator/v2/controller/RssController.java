package com.example.newsaggregator.v2.controller;

import com.example.newsaggregator.v2.dto.RssChannelDTO;
import com.example.newsaggregator.v2.service.RssChannelRepoCustom;
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

    @GetMapping("/channels")
    public ResponseEntity<List<RssChannelDTO>> getAllChannels() {
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(channelRepoCustom.getAllRss());
    }

}
