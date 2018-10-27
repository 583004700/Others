package com.ry.xk.main.dao;


import com.ry.xk.main.bo.Course;
import com.ry.xk.main.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 公共字典dao
 */
@Component
public class CourseDao implements ICourseDao
{
    @Autowired
    CourseMapper courseMapper;

    @Override
    @Cacheable("courses")
    public List<Course> getAll()
    {
        return courseMapper.getAll();
    }
}