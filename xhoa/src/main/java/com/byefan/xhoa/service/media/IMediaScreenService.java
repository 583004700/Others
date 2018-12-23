package com.byefan.xhoa.service.media;

import com.byefan.xhoa.entity.media.MediaScreen;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface IMediaScreenService {
    String CACHE_KEY = "MediaScreen";

    @Cacheable(value = CACHE_KEY)
    List<MediaScreen> all();

    @Cacheable(value = CACHE_KEY)
    List<MediaScreen> list(MediaScreen mediaScreen);

    @Cacheable(value = CACHE_KEY, key = "#mediaTypeId")
    List<MediaScreen> listByMediaTypeId(Integer mediaTypeId);
}
