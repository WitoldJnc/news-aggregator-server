package com.example.newsaggregator.v2.impl;

import com.example.newsaggregator.v2.service.VkApiService;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.wall.responses.GetResponse;
import com.vk.api.sdk.queries.wall.WallGetFilter;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:application.yml")
public class VkApiServiceImpl implements VkApiService {

    @Autowired
    private Environment env;

    @Override
    public void get(String groupName) {
        val vk = new VkApiClient(HttpTransportClient.getInstance());
        final val userActor = initUserActor();
        Integer groupId = getGroupIdByName(groupName, vk, userActor);
        GetResponse recordsFromPublic = getRecordsFromPublic(groupId, vk, userActor);

    }

    @Override
    public Integer getGroupIdByName(String groupName, VkApiClient vk, UserActor actor) {
        if (groupName.contains("public")) {
            return Integer.valueOf(groupName.replace("https://vk.com/public", "").trim());
        }
        groupName = groupName.replace("https://vk.com/", "").trim();
        try {
            return vk.utils().resolveScreenName(actor, groupName).execute().getObjectId();
        } catch (Exception e) {
            return null;
        }
    }

    public GetResponse getRecordsFromPublic(Integer groupid, VkApiClient vk, UserActor userActor) {
        try {
            return vk.wall().get(userActor)
                    .ownerId(-groupid)
                    .filter(WallGetFilter.OWNER)
                    .count(Integer.parseInt(env.getProperty("vk.api.post-count")))
                    .execute();
        } catch (ApiException | ClientException e) {
            return null;
        }
    }

    public UserActor initUserActor() {
        return new UserActor(Integer.parseInt(env.getProperty("vk.api.user")), env.getProperty("vk.api.key"));
    }
}
