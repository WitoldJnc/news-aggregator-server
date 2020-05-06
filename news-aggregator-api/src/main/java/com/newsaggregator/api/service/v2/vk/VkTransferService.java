package com.newsaggregator.api.service.v2.vk;

import com.newsaggregator.api.dto.v2.rss.Item;
import com.vk.api.sdk.objects.wall.WallPostFull;

import java.util.List;

public interface VkTransferService {

    Item createItem(WallPostFull item);

    void transferToFeed(List<WallPostFull> recordsFromPublic);
}
