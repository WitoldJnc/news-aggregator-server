package com.example.newsaggregator.v2.service;

import com.example.newsaggregator.v2.model.RssParent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RssParentService extends JpaRepository<RssParent, Integer> {
}
