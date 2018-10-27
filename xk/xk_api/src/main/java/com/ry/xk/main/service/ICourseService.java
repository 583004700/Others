package com.ry.xk.main.service;

import com.ry.xk.main.bo.Course;
import com.ry.xk.response.bo.CoursesModule;

import java.util.List;


public interface ICourseService
{
    /**
     * 通过partnerID获取所有学科
     * 
     * @param partnerID
     * @return
     */
    public List<Course> getAll(Integer partnerID);

    /**
     * 通过学段获取所有学科
     * 
     * @param partnerId
     * @param courseTypeId
     * @return
     */
    public List<Course> getCourseByCourseType(Integer partnerId, Integer courseTypeId);

    /**
     * 通过学段获取学科并组织成Controller需要的返回类型
     * 
     * @param partnerId
     * @param courseTypeId
     * @return
     */
    public List<CoursesModule> getByCourseType(Integer partnerId, Integer courseTypeId);

    /**
     * 根据ID获取学科
     * 
     * @param partnerId
     * @param courseId
     * @return
     */
    public Course getById(Integer partnerId, Integer courseId);
}
