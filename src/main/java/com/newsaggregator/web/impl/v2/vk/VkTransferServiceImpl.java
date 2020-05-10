package com.newsaggregator.web.impl.v2.vk;


import com.newsaggregator.web.dto.v2.rss.*;
import com.newsaggregator.web.model.v2.RssChannel;
import com.newsaggregator.web.service.v2.RssChannelRepoCustom;
import com.newsaggregator.web.service.v2.vk.VkTransferService;
import com.vk.api.sdk.objects.base.Link;
import com.vk.api.sdk.objects.photos.Photo;
import com.vk.api.sdk.objects.video.Video;
import com.vk.api.sdk.objects.wall.WallPostFull;
import com.vk.api.sdk.objects.wall.WallpostAttachmentType;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class VkTransferServiceImpl implements VkTransferService {

    @Autowired
    private RssChannelRepoCustom channelRepoCustom;

    @Override
    public Item createItem(WallPostFull item) {
        Item rssItem = new Item();

        if (item.getAttachments() == null) {
            return rssItem;
        }

        if (item.getAttachments().get(0).getType().equals(WallpostAttachmentType.LINK)) {
            rssItem = extractLinkItem(item);
        }

        if (item.getAttachments().get(0).getType().equals(WallpostAttachmentType.PHOTO)) {
            rssItem = extractPhotoItem(item);
        }

        if (item.getAttachments().get(0).getType().equals(WallpostAttachmentType.VIDEO)) {
            rssItem = extractVideoItem(item);
        }

        return rssItem;
    }


    @Override
    public Rss transferToFeed(List<WallPostFull> recordsFromPublic, String groupUrl) {
        val items = new ArrayList<Item>();
        Channel channel = new Channel();
        recordsFromPublic.forEach(x -> {
            Item item = createItem(x);
            if (item.getGuid() != null) {
                items.add(item);
            }
        });

        channel.setItems(items);
//        channel.setFeed(extractChannelByResourceUrl(groupUrl));
        channel.setFeed(new Feed("", "resource name", "descr", groupUrl, ""));
        return new Rss(channel);
    }


    @Override
    public Feed extractChannelByResourceUrl(String resourseUrl) {
        RssChannel channel = channelRepoCustom.getResourseByUrl(resourseUrl);
        return Feed.builder()
                .language("ru")
                .title(channel.getLinkToRss())
                .description(channel.getDescription())
                .link(resourseUrl)
                .build();
    }

    @Override
    public Item extractPhotoItem(WallPostFull item) {
        return Item.builder()
                .guid(item.getId().toString())
                .pubDate(new Date(item.getDate()).toString())
                .title(item.getText())
                .enclosure(getEnclosure(item))
                .build();
    }

    @Override
    public Item extractLinkItem(WallPostFull item) {
        Link content = item.getAttachments().get(0).getLink();
        return Item.builder()
                .guid(item.getId().toString())
                .title(content.getTitle())
                .link(content.getUrl())
                .description(content.getDescription())
                .pubDate(new Date(item.getDate()).toString())
                .enclosure(Stream.of(getPhoto(content.getPhoto()))
                        .collect(Collectors.toList()))
                .build();
    }

    private Item extractVideoItem(WallPostFull item) {
        final Video video = item.getAttachments().get(0).getVideo();
        final String preview = Stream.of(video.getPhoto800(), video.getPhoto320(), video.getPhoto130())
                .filter(Objects::nonNull)
                .findFirst().orElse("");

        return Item.builder()
                .guid(item.getId().toString())
                .pubDate(new Date(item.getDate()).toString())
                .title(video.getTitle())
                .description(video.getDescription())
                .enclosure(Stream.of(preview).collect(Collectors.toList()))
                .link(getYouTubeUrl(video))
                .build();
    }

    @Override
    public List<String> getEnclosure(WallPostFull item) {
        List<String> enclosure = new ArrayList<>();
        item.getAttachments().stream()
                .filter(x -> x.getType().equals(WallpostAttachmentType.PHOTO))
                .forEach(x -> enclosure.add(getPhoto(x.getPhoto())));

        return enclosure;
    }

    @Override
    public String getPhoto(Photo photo) {
        return Stream.of(photo.getPhoto1280(), photo.getPhoto807(),
                photo.getPhoto604(), photo.getPhoto130())
                .filter(Objects::nonNull)
                .findFirst().orElse("");
    }

    @Override
    public String getYouTubeUrl(Video video) {
        String link = "";
        if (video.getDescription().contains("youtube") || video.getDescription().contains("youtu.be")) {
            Pattern regex = Pattern.compile("((http(s)?:\\/\\/)?)(www\\.)?((youtube\\.com\\/)|(youtu.be\\/))[\\S]+");
            Matcher matcher = regex.matcher(video.getDescription());
            if (matcher.find()) {
                link = matcher.group();
            }
        }
        return link;
    }
}
