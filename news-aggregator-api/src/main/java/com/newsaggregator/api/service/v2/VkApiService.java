package com.newsaggregator.api.service.v2;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;

public interface VkApiService {
    Integer getGroupIdByName(String groupName, VkApiClient vk, UserActor actor);
    void get(String groupName);
}
