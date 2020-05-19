package com.newsaggregator.web.service.v2;

import com.newsaggregator.web.model.v2.RssCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RssCategoryRepo extends JpaRepository<RssCategory, Integer> {
}
