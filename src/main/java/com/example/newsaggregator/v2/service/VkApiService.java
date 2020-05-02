package com.example.newsaggregator.v2.service;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;

public interface VkApiService {
    Integer getGroupIdByName(String groupName, VkApiClient vk, UserActor actor);
    void get(String groupName);
}
