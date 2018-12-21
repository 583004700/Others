package com.byefan.xhoa.service.media;

import com.byefan.xhoa.entity.media.MediaTerm;

import java.util.List;

public interface IMediaTermService {

    List<MediaTerm> list(Integer typeId);

    MediaTerm getByTerm(MediaTerm term);

    List<MediaTerm> listByTypeId(Integer typeId);
}
