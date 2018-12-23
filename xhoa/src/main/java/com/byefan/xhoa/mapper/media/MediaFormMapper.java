package com.byefan.xhoa.mapper.media;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.xhoa.entity.media.MediaForm;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MediaFormMapper extends BaseMapper<MediaForm, Integer> {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(MediaForm record);

    MediaForm selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MediaForm record);

    int updateByPrimaryKey(MediaForm record);

    @Select("select * from t_media_form where disabled=0 and  media_type_id=#{mediaTypeId} ORDER BY sort_no ")
    List<MediaForm> listByMediaTypeId(@Param("mediaTypeId") Integer mediaTypeId);
}