package com.ry.xk.main.mapper;


import com.ry.xk.main.bo.Course;

import org.mapstruct.Mapper;

import java.util.List;


/**
 * 学科mapper
 */
@Mapper
public interface CourseMapper
{
    /**
     * 获取所有学科数据
     * 
     * @return
     */
    public List<Course> getAll();
}