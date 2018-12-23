package com.byefan.xhoa.mapper;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.xhoa.entity.sys.District;

public interface DistrictMapper extends BaseMapper<District, Integer> {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(District record);

    District selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);
}