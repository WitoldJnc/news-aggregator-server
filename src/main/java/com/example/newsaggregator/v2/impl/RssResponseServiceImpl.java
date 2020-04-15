package com.example.newsaggregator.v2.impl;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Service
public class RssResponseServiceImpl {

    @PersistenceContext
    public EntityManager entityManager;

    public void getAllFeedByResource() {

    }



    public void getFeedByTheme() {
    }

}
