package com.ry.xk.main.service;


import com.ry.xk.Application;
import com.ry.xk.common.bo.CommonDictionary;
import com.ry.xk.main.bo.Course;
import com.ry.xk.main.bo.Partner;
import com.ry.xk.main.bo.PartnerCourseMapping;
import com.ry.xk.main.dao.ICourseDao;
import com.ry.xk.main.dao.IPartnerDao;
import com.ry.xk.response.bo.CoursesModule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class CourseServiceTest
{
    @Mock
    IPartnerDao partnerDao;

    @Mock
    ICourseDao courseDao;

    @Autowired
    @InjectMocks
    ICourseService courseService;

    @Test
    public void getCourseTypes()
    {
        Partner partner = ObjectFactory.getPartner();

        Mockito.when(partnerDao.get(1)).thenReturn(partner);

        List<Course> courses = ObjectFactory.getCourses();

        Mockito.when(courseDao.getAll()).thenReturn(courses);

        List<CoursesModule> partnerCourses = courseService.getByCourseType(1,2);

        partnerCourses.forEach((o)->System.out.println(o.getCourseId()+"------------"+o.getCourseName()));

        //assertNotNull(partnerService.getCourseTypes(1));
    }
}
