package com.newsaggregator.impl.service.impl.v2.vk;

import com.newsaggregator.api.dto.v2.rss.Item;
import com.newsaggregator.api.service.v2.vk.VkTransferService;
import com.vk.api.sdk.objects.wall.WallPostFull;
import com.vk.api.sdk.objects.wall.WallpostAttachmentType;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VkTransferServiceImpl implements VkTransferService {

    @Override
    public Item createItem(WallPostFull item) {
        Item rssItem = new Item();
        if (item.getAttachments().get(0).getType().equals(WallpostAttachmentType.PHOTO)) {
            rssItem = extractPhotoItem(item);
        }
        if (item.getAttachments().get(0).getType().equals(WallpostAttachmentType.LINK)) {
            rssItem = extractLinkItem(item);
        }

        return rssItem;
    }

    @Override
    public void transferToFeed(List<WallPostFull> recordsFromPublic) {
        val items = new ArrayList<Item>();
        recordsFromPublic
                .forEach(x -> {
                    Item item = createItem(x);
                    if (!item.getGuid().equals("") || item.getGuid() != null) {
                        items.add(item);
                    }
                });

    }


    public Item extractPhotoItem(WallPostFull item) {
        return null;
    }

    public Item extractLinkItem(WallPostFull item) {
        return null;
    }
}
