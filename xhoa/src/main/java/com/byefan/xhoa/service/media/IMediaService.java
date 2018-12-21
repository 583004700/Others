package com.byefan.xhoa.service.media;

import com.byefan.xhoa.entity.media.Media;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public interface IMediaService {
    String CACHE_KEY = "media";

    /**
     * 根据媒体信息条件 分页查询媒体信息
     *
     * @param media    媒体信息
     * @param pageable 分页对象
     * @return
     */
    PageInfo<Media> list(Media media, Pageable pageable);

    void save(Media media);

    @Transactional
    Media update(Media media);

    boolean getByName(int mType, String mediaName);

    Media getById(Integer id);

    /**
     * 审核通过
     *
     * @param id
     * @return
     */
    boolean pass(Integer id);

    /**
     * 审核驳回
     *
     * @param id
     * @return
     */
    boolean reject(Integer id);
    /**
     * 审核删除
     *
     * @param id
     * @return
     */
    boolean del(Integer id);
}