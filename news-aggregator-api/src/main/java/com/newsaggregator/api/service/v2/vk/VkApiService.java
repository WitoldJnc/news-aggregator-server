package com.newsaggregator.api.service.v2.vk;

import com.newsaggregator.api.dto.v2.rss.Rss;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.wall.responses.GetResponse;
import org.springframework.http.ResponseEntity;

public interface VkApiService {
    Integer getGroupIdByName(String groupName, VkApiClient vk, UserActor actor);

    ResponseEntity<Rss> getVkFeed(String groupName);

    GetResponse getRecordsFromPublic(Integer groupid, VkApiClient vk, UserActor userActor);

    UserActor initUserActor();
}
