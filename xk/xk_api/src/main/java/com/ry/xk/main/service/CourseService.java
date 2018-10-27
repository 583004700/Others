package com.ry.xk.main.service;


import com.ry.xk.main.bo.Course;
import com.ry.xk.main.bo.Partner;
import com.ry.xk.main.bo.PartnerCourseMapping;
import com.ry.xk.main.dao.ICourseDao;
import com.ry.xk.main.dao.IPartnerDao;
import com.ry.xk.response.bo.CoursesModule;
import com.ry.xk.utils.UrlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CourseService implements ICourseService
{
    private static final Logger log = LoggerFactory.getLogger(CourseService.class);

    @Autowired
    ICourseDao courseDao;

    @Autowired
    IPartnerDao partnerDao;

    @Override
    public List<Course> getAll(Integer partnerID)
    {
        // 获取到所有学科数据
        List<Course> courses = courseDao.getAll();
        if (courses == null)
        {
            return new ArrayList<Course>();
        }
        Partner partner = partnerDao.get(partnerID);
        if (partner == null)
        {
            return new ArrayList<Course>();
        }
        // 获取机构下的所有学科映射
        List<PartnerCourseMapping> courseMappings = partner.getPartnerCourseMappings();
        // 取交集得到用户的学科
        List<Course> partnerCourses = courses.stream().filter((o) -> {
            boolean b = courseMappings.stream().anyMatch((t) -> t.getCourseId() == o.getCourseId());
            return b;
        }).collect(Collectors.toList());
        return partnerCourses;
    }

    /**
     * 通过学段获取所有学科
     * 
     * @param partnerId
     * @param courseTypeId
     * @return
     */
    public List<Course> getCourseByCourseType(Integer partnerId, Integer courseTypeId)
    {
        List<Course> allCourse = getAll(partnerId);
        List<Course> list = allCourse.stream().filter((o) -> o.getCourseTypeId() - courseTypeId == 0).collect(Collectors.toList());
        return list;
    }

    /**
     * 通过学段获取,组织好层参数并返回
     * 
     * @param partnerId
     * @param courseTypeId
     * @return
     */
    @Override
    public List<CoursesModule> getByCourseType(Integer partnerId, Integer courseTypeId)
    {
        List<Course> list = getCourseByCourseType(partnerId, courseTypeId);
        List<CoursesModule> courseListModules = new ArrayList<CoursesModule>();
        list.forEach((o) -> {
            try {
                String courseId = UrlUtil.idEncrypt(o.getCourseId());
                courseListModules.add(new CoursesModule(courseId, o.getCourseName(), o.getShortCode()));
            }catch (Exception e){
                log.error("加密学段ID异常partnerId"+partnerId+"courseTypeId"+courseTypeId,e);
            }
        });
        return courseListModules;
    }

    /**
     * 根据ID获取学科
     * 
     * @param partnerId
     * @param courseId
     * @return
     */
    public Course getById(Integer partnerId, Integer courseId)
    {
        List<Course> partnerCourse = getAll(partnerId);
        for (int i = 0; i < partnerCourse.size(); i++ )
        {
            if (courseId - partnerCourse.get(i).getCourseId() == 0)
            {
                return partnerCourse.get(i);
            }
        }
        return null;
    }
}
