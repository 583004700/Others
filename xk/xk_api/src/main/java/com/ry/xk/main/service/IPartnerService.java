package com.ry.xk.main.service;

import com.ry.xk.response.bo.CourseType;

import java.util.List;


public interface IPartnerService
{
    /**
     * 获取所有学段
     * @param partnerID
     * @return
     */
    public List<CourseType> getCourseTypes(Integer partnerID);
}
