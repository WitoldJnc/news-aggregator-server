package com.newsaggregator.api.service.v2.vk;

import com.newsaggregator.api.dto.v2.rss.Rss;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import org.springframework.http.ResponseEntity;

public interface VkApiService {
    Integer getGroupIdByName(String groupName, VkApiClient vk, UserActor actor);

    ResponseEntity<Rss> get(String groupName);
}
