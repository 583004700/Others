package com.byefan.xhoa.service.media;

import com.byefan.xhoa.entity.media.MediaName;

import java.util.List;

public interface IMediaNameService {
    List<MediaName> all();

    List<MediaName> list(MediaName mediaName);
}
