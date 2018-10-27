package com.ry.xk.main.service;

import com.ry.xk.Application;
import com.ry.xk.common.bo.ResponseBase;
import com.ry.xk.studentexamresult.bo.ExamPaper;
import com.ry.xk.studentexamresult.dao.IExamPaperDao;
import com.ry.xk.studentexamresult.service.IUserResourceService;
import io.swagger.models.auth.In;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserResourceServiceTest {
    int userId = 1;
    int examPaperId = 1;
    @Autowired
    @InjectMocks
    IUserResourceService userResourceService;
    @Mock
    IExamPaperDao examPaperDao;
    @Test
    public void getFreeExamPaper(){
        ExamPaper examPaper = ObjectFactory.getExamPaper().get(0);
        Mockito.when(examPaperDao.get(examPaperId)).thenReturn(examPaper);
        ResponseBase<Integer> x = userResourceService.getFreeExamPaper(userId,examPaperId);
        //Assert.assertTrue(x.isReturnEntity() == 1);
        System.out.println(x.getMessage());
    }

    @Test
    //测试当试卷不是免费的时候
    public void getFreeExamPaperWhenExamNotFree(){
        ExamPaper examPaper = ObjectFactory.getExamPaper().get(1);
        Mockito.when(examPaperDao.get(examPaperId)).thenReturn(examPaper);
        ResponseBase<Integer> x = userResourceService.getFreeExamPaper(userId,examPaperId);
        Assert.assertTrue(x.isReturnEntity() == 0);
        System.out.println(x.getMessage());
    }
}
