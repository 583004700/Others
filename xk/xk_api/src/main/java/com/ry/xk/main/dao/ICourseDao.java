package com.ry.xk.main.dao;


import com.ry.xk.main.bo.Course;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 学科dao
 */
@Component
public interface ICourseDao
{
    /**
     * 获取字典表所有数据
     * 
     * @return
     */
    public List<Course> getAll();
}