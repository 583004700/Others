package com.byefan.xhoa.mapper.media;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.xhoa.entity.media.MediaScreen;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MediaScreenMapper extends BaseMapper<MediaScreen, Integer> {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(MediaScreen record);

    MediaScreen selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MediaScreen record);

    int updateByPrimaryKey(MediaScreen record);

    @Select("select * from t_media_screen where state=0 and media_type_id=#{mediaTypeId}")
    List<MediaScreen> listByMediaTypeId(@Param("mediaTypeId") Integer mediaTypeId);
}