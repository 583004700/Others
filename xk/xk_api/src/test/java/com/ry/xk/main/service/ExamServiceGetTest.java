package com.ry.xk.main.service;

import com.ry.xk.Application;
import com.ry.xk.common.CommonConst;
import com.ry.xk.request.bo.GenerateExamDataRequest;
import com.ry.xk.response.bo.ExamModule;
import com.ry.xk.studentexamresult.bo.*;
import com.ry.xk.studentexamresult.dao.*;
import com.ry.xk.studentexamresult.service.IExamService;
import com.ry.xk.utils.DateUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.never;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ExamServiceGetTest
{
    int userId = 1;
    int studentExamId = 100;
    @Mock
    IStudentExamInProgressInfoDao studentExamInProgressInfoDao;
    @Mock
    IStudentExamDao studentExamDao;

    @Autowired
    @InjectMocks
    IExamService examService;

    @Test
    //测试当测试缓存数据和正在做的题数据不存在时
    public void getWhenStudentExamItemStudentExamInProgressInfoIsNull() throws Exception{
        StudentExamInProgressInfo studentExamInProgressInfo = null;
        StudentExamList studentExamList = null;
        Mockito.when(studentExamInProgressInfoDao.get(studentExamId)).thenReturn(studentExamInProgressInfo);
        Mockito.when(studentExamDao.getStudentExamList(userId)).thenReturn(studentExamList);
        ExamModule examModule = examService.get(userId,studentExamId);
        Assert.assertTrue(examModule == null);
    }

    @Test
    //正常数据测试
    public void get() throws Exception{
        StudentExamInProgressInfo studentExamInProgressInfo = ObjectFactory.getStudentExamInProgressInfo();
        StudentExamList studentExamList = ObjectFactory.getStudentExamList();
        Mockito.when(studentExamInProgressInfoDao.get(studentExamId)).thenReturn(studentExamInProgressInfo);
        Mockito.when(studentExamDao.getStudentExamList(userId)).thenReturn(studentExamList);
        ExamModule examModule = examService.get(userId,studentExamId);
        Assert.assertTrue(examModule.getExamTime() == 24*60 &&
                examModule.getExamTimed() - DateUtil.second(DateUtil.parse("2018-07-01","yyyy-MM-dd"),new Date()) == 0 &&
        examModule.getQuestionCount() == 2 && examModule.getDoneQuestionCount() == 1 && examModule.getAnswerSheets().get(0).getIsDone() == true);
    }
}
