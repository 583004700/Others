package com.byefan.xhoa.mapper.media;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.xhoa.entity.media.MediaTerm;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MediaTermMapper extends BaseMapper<MediaTerm, Integer> {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(MediaTerm record);

    MediaTerm selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MediaTerm record);

    int updateByPrimaryKey(MediaTerm record);

    @Select("select * from t_media_term where state=0 and type_id=#{typeId}")
    List<MediaTerm> listByTypeId(@Param("typeId") Integer typeId);
}