package com.newsaggregator.web.service.v2;


import com.newsaggregator.web.dto.v2.RssChannelDTO;
import com.newsaggregator.web.model.v2.RssChannel;

import java.util.List;

public interface RssChannelRepoCustom {
    List<RssChannelDTO> getAllRss();

    List<RssChannel> getChannelsByParent(Integer parentId);

    RssChannel getResourseByUrl(String url);
}
