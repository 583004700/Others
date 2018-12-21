package com.byefan.xhoa.service.impl.media;

import com.byefan.xhoa.entity.media.MediaScreen;
import com.byefan.xhoa.mapper.media.MediaScreenMapper;
import com.byefan.xhoa.service.media.IMediaScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MediaScreenService implements IMediaScreenService {
    @Autowired
    MediaScreenMapper mediaScreenMapper;

    @Override
    public List<MediaScreen> all() {
        return mediaScreenMapper.all(MediaScreen.class);
    }

    @Override
    public List<MediaScreen> list(MediaScreen mediaScreen) {
        return mediaScreenMapper.list(mediaScreen);
    }

    @Override
    public List<MediaScreen> listByMediaTypeId(Integer mediaTypeId) {
        return mediaScreenMapper.listByMediaTypeId(mediaTypeId);
    }
}
