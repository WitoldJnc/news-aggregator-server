package com.newsaggregator.impl.service.impl.v2;

import com.newsaggregator.api.dto.v2.RssChannelDTO;
import com.newsaggregator.api.model.v2.RssChannel;
import com.newsaggregator.api.service.v2.RssChannelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class RssChannelRepoCustom implements com.newsaggregator.api.service.v2.RssChannelRepoCustom {

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

    @Override
    public RssChannel getResourseByUrl(String url) {
        return (RssChannel) entityManager.createNativeQuery("select * from scrum_rss_channel " +
                "where link_to_rss = :link", RssChannel.class)
                .setParameter("link", url)
                .getSingleResult();
    }
}
