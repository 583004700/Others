package com.ry.xk.main.mapper;


import com.ry.xk.common.bo.CommonDictionary;
import com.ry.xk.main.bo.Partner;
import com.ry.xk.main.bo.PartnerCourseMapping;
import com.ry.xk.response.bo.CourseType;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;


/**
 * 合作伙伴mapper
 */
@Mapper
public interface PartnerMapper
{
    /**
     * 根据partnerID查询单条记录
     */
    public Partner get(@Param("partnerId") Integer partnerId);

    /**
     * 根据partnerID查询映射集合
     * 
     * @param partnerId
     * @return
     */
    public List<PartnerCourseMapping> getPartnerCourseMapping(@Param("partnerId") Integer partnerId);

    /**
     * 根据CourseTypeID获取学段
     */
    public CommonDictionary getCourseType(Integer courseTypeId);
}