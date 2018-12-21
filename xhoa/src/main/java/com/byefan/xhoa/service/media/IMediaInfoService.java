package com.byefan.xhoa.service.media;

import com.byefan.xhoa.entity.media.MediaInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public interface IMediaInfoService {
    String CACHE_KEY = "mediaInfo";

    /**
     * 根据媒体信息条件 分页查询媒体信息
     *
     * @param mediaInfo    媒体信息
     * @param pageable 分页对象
     * @return
     */
    PageInfo<MediaInfo> list(MediaInfo mediaInfo, Pageable pageable);

    void save(MediaInfo mediaInfo);

    /**
     * 查询媒体表写入媒体信息表中
     * @param mediaId
     */
    void selectToSave(Integer mediaId);

    /**
     * 查询媒体表更新到媒体信息表中
     * @param mediaId
     */
    void selectToUpdate(Integer mediaId);



    @Transactional
    MediaInfo update(MediaInfo mediaInfo);

    boolean getByName(int mType, String mediaName);

    MediaInfo getById(Integer id);

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

    void modifyStateById(int i, Integer id);
}