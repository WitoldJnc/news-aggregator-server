package com.example.newsaggregator.v2.service;

import com.example.newsaggregator.v2.model.RssChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RssChannelRepo extends JpaRepository<RssChannel, Integer> {
    List<RssChannel> getAllByIsParentIsTrue();
}
