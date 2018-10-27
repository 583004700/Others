package com.ry.xk.main.service;


import com.ry.xk.Application;
import com.ry.xk.common.bo.CommonDictionary;
import com.ry.xk.main.bo.Partner;
import com.ry.xk.main.bo.PartnerCourseMapping;
import com.ry.xk.main.dao.IPartnerDao;
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
public class PartnerServiceTest
{
    @Mock
    IPartnerDao partnerDao;

    @Mock
    ICommonDictionaryService commonDictionaryService;



    @Autowired
    @InjectMocks
    IPartnerService partnerService;

    @Test
    public void getCourseTypes()
    {

        Partner partner = ObjectFactory.getPartner();

        Mockito.when(partnerDao.get(1)).thenReturn(partner);

        //获取公共字典
        List<CommonDictionary> commonDictionaries = ObjectFactory.getCommonDictionary();

        Mockito.when(commonDictionaryService.get("CourseType")).thenReturn(commonDictionaries);

        partnerService.getCourseTypes(1).forEach((o)->System.out.println(o.getCourseTypeId()+"---------"+o.getCourseTypeName()));
        //assertNotNull(partnerService.getCourseTypes(1));
    }
}
