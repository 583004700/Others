package com.byefan.xhoa.mapper;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.xhoa.entity.media.Industry;

public interface IndustryMapper extends BaseMapper<Industry,Integer> {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Industry record);

    Industry selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Industry record);

    int updateByPrimaryKey(Industry record);

}