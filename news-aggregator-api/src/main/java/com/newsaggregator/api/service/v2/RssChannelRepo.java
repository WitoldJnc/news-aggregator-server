package com.newsaggregator.api.service.v2;

import com.newsaggregator.api.model.v2.RssChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RssChannelRepo extends JpaRepository<RssChannel, Integer> {
    List<RssChannel> getAllByIsParentIsTrue();
}
