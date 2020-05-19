package com.newsaggregator.web.controller.v2;

import com.newsaggregator.web.service.v2.RssCategoryRepo;
import com.newsaggregator.web.service.v2.RssChannelRepoCustom;
import com.newsaggregator.web.service.v2.rss.RssToJsonService;
import com.newsaggregator.web.service.v2.vk.VkApiService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseController {
    @Autowired
    protected RssChannelRepoCustom channelRepoCustom;

    @Autowired
    protected RssToJsonService rssToJsonService;

    @Autowired
    protected VkApiService vkApiService;

    @Autowired
    protected RssCategoryRepo categoryRepo;
}
