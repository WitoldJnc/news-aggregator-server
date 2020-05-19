package com.newsaggregator.web.dto.v2.vk;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhotoVk extends com.vk.api.sdk.objects.photos.Photo {
    private String photo130;
    private String photo604;
    private String photo807;
    private String photo1280;
}
