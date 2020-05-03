package com.newsaggregator.api.dto.v2;

import com.newsaggregator.api.model.v2.RssChannel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RssChannelDTO {
    Integer id;
    String description;
    String linkToResource;
    List<RssChannel> channels;
}
