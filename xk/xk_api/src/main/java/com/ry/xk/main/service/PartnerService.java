package com.ry.xk.main.service;

import com.ry.xk.common.CommonConst;
import com.ry.xk.common.bo.CommonDictionary;
import com.ry.xk.main.bo.Partner;
import com.ry.xk.main.bo.PartnerCourseMapping;
import com.ry.xk.main.dao.IPartnerDao;
import com.ry.xk.response.bo.CourseType;
import com.ry.xk.utils.ListHelper;
import com.ry.xk.utils.UrlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartnerService implements IPartnerService
{
    private static final Logger log = LoggerFactory.getLogger(PartnerService.class);

    @Autowired
    IPartnerDao partnerDao;

    @Autowired
    ICommonDictionaryService commonDictionaryService;

    public List<CourseType> getCourseTypes(Integer partnerID)
    {
        // 从缓存中取出数据，如果缓存中没有，则从数据库中取
        Partner partner = partnerDao.get(partnerID);
        if (partner == null)
        {
            return new ArrayList<CourseType>();
        }
        // 将学段进行去重
        List<PartnerCourseMapping> newPartnerMapping = ListHelper.removeRepeat(partner.getPartnerCourseMappings(), (o) -> o.getCourseTypeId());
        // 得到字典所有数据
        List<CommonDictionary> commonDictionaries = commonDictionaryService.get(String.valueOf(CommonConst.COMMONDICTIONARYTYPE_COUSETYPE));
        if (commonDictionaries == null)
        {
            return new ArrayList<CourseType>();
        }
        // 取newPartnerMapping和commonDictionaries交集
        List<CommonDictionary> newcommonDictionaries = commonDictionaries.stream().filter(t -> newPartnerMapping.stream().anyMatch((o) -> o.getCourseTypeId() - t.getItemKey() == 0)).collect(
            Collectors.toList());
        // 按orderIndex排序
        newcommonDictionaries.sort((o1, o2) -> o1.getOrderIndex() - o2.getOrderIndex());
        List<CourseType> courseTypes = new ArrayList<CourseType>();
        // 添加到courseTypes集合中
        newcommonDictionaries.forEach((o) -> {
            CourseType courseType = new CourseType();
            courseType.setCourseTypeId(o.getItemKey());
            courseType.setCourseTypeName(o.getItemValue());
            courseTypes.add(courseType);
        });
        return courseTypes;
    }
}
