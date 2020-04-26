package com.example.newsaggregator.v2.dto;

import com.example.newsaggregator.v2.model.RssChannel;
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
