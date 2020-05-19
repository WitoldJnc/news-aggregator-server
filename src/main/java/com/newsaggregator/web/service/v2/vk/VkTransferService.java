package com.newsaggregator.web.service.v2.vk;


import com.newsaggregator.web.dto.v2.rss.Feed;
import com.newsaggregator.web.dto.v2.rss.Item;
import com.newsaggregator.web.dto.v2.rss.Rss;
import com.vk.api.sdk.objects.photos.Photo;
import com.vk.api.sdk.objects.wall.WallPost;
import com.vk.api.sdk.objects.wall.WallPostFull;

import java.util.List;

public interface VkTransferService {

    Item createItem(WallPost item);

    Rss transferToFeed(List<WallPostFull> recordsFromPublic, String groupUrl);

    Feed extractChannelByResourceUrl(String resourseUrl);

    Item extractPhotoItem(WallPost item);

    Item extractLinkItem(WallPost item);

    List<String> getEnclosure(WallPost item);

    String getPhoto(Photo photo);

    String getYouTubeUrl(String descr);
}
