package com.ry.xk.main.dao;


import com.ry.xk.common.bo.CommonDictionary;
import com.ry.xk.main.bo.Partner;
import com.ry.xk.main.bo.PartnerCourseMapping;
import com.ry.xk.response.bo.CourseType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
public interface ICommonDictionaryDao
{
    /**
     * 获取字典表所有数据
     * @return
     */
    public List<CommonDictionary> getAll();
}