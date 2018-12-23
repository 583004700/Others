package com.byefan.xhoa.mapper.media;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.xhoa.entity.media.MediaName;
import com.byefan.xhoa.entity.media.MediaTerm;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MediaNameMapper extends BaseMapper<MediaName, Integer> {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(MediaName record);

    MediaName selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MediaName record);

    int updateByPrimaryKey(MediaName record);

    @Select("select * from t_media_name state=0 and  where type_id=#{typeId}")
    List<MediaTerm> listByTypeId(@Param("typeId") Integer typeId);

    @Select("select * from t_media_name where state=0 and id=#{id}")
    MediaTerm getById(@Param("id") Integer id);
}