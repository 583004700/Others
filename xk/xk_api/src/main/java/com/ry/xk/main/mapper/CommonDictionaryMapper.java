package com.ry.xk.main.mapper;


import com.ry.xk.common.bo.CommonDictionary;

import com.ry.xk.response.bo.CourseType;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;


/**
 * 公共字典表mapper
 */
@Mapper
public interface CommonDictionaryMapper
{
    /**
     * 获取字典表所有数据
     * @return
     */
    public List<CommonDictionary> getAll();
}