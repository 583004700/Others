package com.byefan.xhoa.service.impl.media;

import com.byefan.xhoa.entity.media.MediaForm;
import com.byefan.xhoa.mapper.media.MediaFormMapper;
import com.byefan.xhoa.service.media.IMediaFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MediaFormService implements IMediaFormService {
    @Autowired
    MediaFormMapper mediaFormMapper;
    private static final String CACHE_KEY = "MediaForm";

    @Override
    @Cacheable(value = CACHE_KEY)
    public List<MediaForm> all() {
        return mediaFormMapper.all(MediaForm.class);
    }

    @Override
    @Cacheable(value = CACHE_KEY)
    public List<MediaForm> list(MediaForm mediaForm) {
        return mediaFormMapper.listByOrder(mediaForm, "sort_no");
    }

    @Override
    @Cacheable(value = CACHE_KEY, key = "#mediaTypeId")
    public List<MediaForm> listByMediaTypeId(Integer mediaTypeId) {
        return mediaFormMapper.listByMediaTypeId(mediaTypeId);
    }

}
