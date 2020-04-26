package com.example.newsaggregator.v2.impl;

import com.example.newsaggregator.v2.dto.RssChannelDTO;
import com.example.newsaggregator.v2.model.RssChannel;
import com.example.newsaggregator.v2.service.RssChannelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class RssChannelRepoCustom implements com.example.newsaggregator.v2.service.RssChannelRepoCustom {

    @Autowired
    private RssChannelRepo channelRepo;

    @PersistenceContext
    public EntityManager entityManager;

    @Override
    public List<RssChannelDTO> getAllRss() {
        List<RssChannel> allByIsParentIsTrue = channelRepo.getAllByIsParentIsTrue();
        List<RssChannelDTO> dtos = new ArrayList<>();
        allByIsParentIsTrue
                .forEach(x -> {
                    RssChannelDTO dto = new RssChannelDTO();
                    dto.setLinkToResource(x.getLinkToResource());
                    dto.setDescription(x.getDescription());
                    dto.setId(x.getId());
                    dto.setChannels(getChannelsByParent(x.getId()));
                    dto.getChannels().forEach(c -> c.setParent(null));
                    dtos.add(dto);
                });

        return dtos;
    }

    @Override
    public List<RssChannel> getChannelsByParent(Integer parentId) {
        return entityManager.createNativeQuery("select * from scrum_rss_channel where parent_id = :id", RssChannel.class)
                .setParameter("id", parentId)
                .getResultList();
    }
}
