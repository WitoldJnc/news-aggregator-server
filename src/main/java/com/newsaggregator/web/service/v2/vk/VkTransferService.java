package com.newsaggregator.web.service.v2.vk;


import com.newsaggregator.web.dto.v2.rss.Feed;
import com.newsaggregator.web.dto.v2.rss.Item;
import com.newsaggregator.web.dto.v2.rss.Rss;
import com.vk.api.sdk.objects.photos.Photo;
import com.vk.api.sdk.objects.video.Video;
import com.vk.api.sdk.objects.wall.WallPostFull;

import java.util.List;

public interface VkTransferService {

    Item createItem(WallPostFull item);

    Rss transferToFeed(List<WallPostFull> recordsFromPublic, String groupUrl);

    Feed extractChannelByResourceUrl(String resourseUrl);

    Item extractPhotoItem(WallPostFull item);

    Item extractLinkItem(WallPostFull item);

    List<String> getEnclosure(WallPostFull item);

    String getPhoto(Photo photo);

    String getYouTubeUrl(Video video);
}
