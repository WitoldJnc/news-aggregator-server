package com.example.newsaggregator.v2.service;

import com.example.newsaggregator.v2.dto.RssChannelDTO;
import com.example.newsaggregator.v2.model.RssChannel;

import java.util.List;

public interface RssChannelRepoCustom {
    List<RssChannelDTO> getAllRss();
    List<RssChannel> getChannelsByParent(Integer parentId);
}
