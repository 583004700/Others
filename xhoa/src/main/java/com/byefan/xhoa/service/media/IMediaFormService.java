package com.byefan.xhoa.service.media;

import com.byefan.xhoa.entity.media.MediaForm;

import java.util.List;

public interface IMediaFormService {
    List<MediaForm> all();

    List<MediaForm> list(MediaForm mediaForm);

    List<MediaForm> listByMediaTypeId(Integer mediaTypeId);
}
