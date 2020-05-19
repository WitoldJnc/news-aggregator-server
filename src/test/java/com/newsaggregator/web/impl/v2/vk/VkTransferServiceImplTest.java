package com.newsaggregator.web.impl.v2.vk;

import com.newsaggregator.web.dto.v2.vk.PhotoVk;
import com.newsaggregator.web.service.v2.vk.VkTransferService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class VkTransferServiceImplTest {

    @Autowired
    private VkTransferService transferService;


    @Test
    void getPhoto() {
        PhotoVk photo1280 = PhotoVk.builder().photo1280("1280").photo807("807").photo604("604").photo130("130").build();
        PhotoVk photo807 = PhotoVk.builder().photo1280(null).photo807("807").photo604("604").photo130("130").build();
        PhotoVk photoNull = PhotoVk.builder().photo1280(null).photo807(null).photo604(null).photo130(null).build();

        Assertions.assertEquals("1280", transferService.getPhoto(photo1280));
        Assertions.assertEquals("807", transferService.getPhoto(photo807));
        Assertions.assertEquals("", transferService.getPhoto(photoNull));
        Assertions.assertNotNull(transferService.getPhoto(photoNull));
    }

    @Test
    void getYouTubeUrl() {
        String descriptionWithYoutubeLink = "description with https://www.youtube.com/123test link";
        String descriptionWithSmallYoutubeLink = "description with https://youtu.be/123test link";
        String descriptionWithoutLink = "description with without link https://test test youtube.com youtu.be";

        Assertions.assertEquals("https://www.youtube.com/123test", transferService.getYouTubeUrl(descriptionWithYoutubeLink));
        Assertions.assertEquals("https://youtu.be/123test", transferService.getYouTubeUrl(descriptionWithSmallYoutubeLink));
        Assertions.assertEquals("", transferService.getYouTubeUrl(descriptionWithoutLink));
        Assertions.assertNotNull(transferService.getYouTubeUrl(descriptionWithoutLink));
    }
}