package com.ry.xk.main.dao;


import com.ry.xk.common.bo.CommonDictionary;
import com.ry.xk.main.bo.Partner;
import com.ry.xk.main.bo.PartnerCourseMapping;
import com.ry.xk.main.mapper.PartnerMapper;
import com.ry.xk.response.bo.CourseType;
import com.ry.xk.utils.CacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * 合作伙伴dao
 * 
 * @author 朱未斌
 */
@Component
public class PartnerDao implements IPartnerDao
{
    @Autowired
    PartnerMapper partnerMapper;
    /**
     * 获取一个合作伙伴
     * @param partnerID
     * @return
     */
    @Override
    public Partner get(Integer partnerID)
    {
        Partner partner = new Partner();
        partner.setPartnerId(partnerID);
        Partner newPartner = CacheUtil.get(partner, () -> {
            Partner fullPartner = partnerMapper.get(partnerID);
            if (fullPartner != null)
            {
                List<PartnerCourseMapping> fullPartnerCourseMapping = partnerMapper.getPartnerCourseMapping(partnerID);
                fullPartner.setPartnerCourseMappings(fullPartnerCourseMapping);
            }
            return fullPartner;
        });
        if (newPartner != null && newPartner.getPartnerCourseMappings() == null)
        {
            newPartner.setPartnerCourseMappings(new ArrayList<PartnerCourseMapping>());
        }
        return newPartner;
    }

    @Override
    public List<PartnerCourseMapping> getPartnerCourseMapping(Integer partnerID)
    {
        return partnerMapper.getPartnerCourseMapping(partnerID);
    }

    @Override
    public CommonDictionary getCourseType(Integer courseTypeID)
    {
        return getCourseType(courseTypeID);
    }
}