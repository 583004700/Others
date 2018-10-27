package com.ry.xk.main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.ry.xk.common.bo.CommonDictionary;
import com.ry.xk.main.bo.Partner;
import com.ry.xk.main.bo.PartnerCourseMapping;

/**
 * 合作伙伴dao
 */
@Component
public interface IPartnerDao
{
    /**
     * 根据partnerID查询单条记录
     */
    public Partner get(@Param("partnerID") Integer partnerID);

    /**
     * 根据partnerID查询映射集合
     * 
     * @param partnerID
     * @return
     */
    public List<PartnerCourseMapping> getPartnerCourseMapping(@Param("partnerID") Integer partnerID);

    /**
     * 根据CourseTypeID获取学段
     */
    public CommonDictionary getCourseType(Integer courseTypeID);
}