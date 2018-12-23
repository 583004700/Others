package com.byefan.xhoa.service.impl.media;

import com.byefan.xhoa.entity.media.MediaName;
import com.byefan.xhoa.mapper.media.MediaNameMapper;
import com.byefan.xhoa.service.media.IMediaNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MediaNameService implements IMediaNameService {
    @Autowired
    MediaNameMapper mediaNameMapper;
    private static final String CACHE_KEY = "MediaName";

    @Override
    @Cacheable(value = CACHE_KEY)
    public List<MediaName> all(){
        return mediaNameMapper.all(MediaName.class);
    }

    @Override
    @Cacheable(value = CACHE_KEY)
    public List<MediaName> list(MediaName mediaName) {
        return mediaNameMapper.list(mediaName);
    }

}
