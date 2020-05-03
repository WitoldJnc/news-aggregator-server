package com.newsaggregator.api.service.v2;

import com.newsaggregator.api.dto.v2.RssChannelDTO;
import com.newsaggregator.api.model.v2.RssChannel;

import java.util.List;

public interface RssChannelRepoCustom {
    List<RssChannelDTO> getAllRss();

    List<RssChannel> getChannelsByParent(Integer parentId);
}
