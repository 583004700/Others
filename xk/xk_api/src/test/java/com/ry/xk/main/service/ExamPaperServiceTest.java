package com.ry.xk.main.service;


import com.ry.xk.Application;
import com.ry.xk.common.CommonConst;
import com.ry.xk.response.bo.ExamPaperDetailModule;
import com.ry.xk.response.bo.ExamPaperListModule;
import com.ry.xk.studentexamresult.bo.*;
import com.ry.xk.studentexamresult.dao.*;
import com.ry.xk.studentexamresult.service.IExamPaperService;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;


@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ExamPaperServiceTest
{
    @Mock
    IExamPaperDao examPaperDao;

    @Mock
    IStudentExamDao studentExamDao;

    @Mock
    IUserResourceDao userResourceDao;

    @Mock
    IStudentExamInProgressInfoDao studentExamInProgressInfoDao;

    @Mock
    IStudentExamResultDao studentExamResultDao;

    @Autowired
    @InjectMocks
    IExamPaperService examPaperService;

    int courseId = 1;

    int startIndex = 0;

    int pageSize = 25;

    int userId = 1;

    long steId = 1;

    int examPaperId = 1;

    int partnerId = 1;

    @Test
    // 获取已做题目和总题数
    public void getAnswerSituation()
    {
        StudentExamInProgressInfo studentExamInProgressInfo = ObjectFactory.getStudentExamInProgressInfo();
        Mockito.when(studentExamInProgressInfoDao.get(steId)).thenReturn(studentExamInProgressInfo);
        System.out.println(examPaperService.getAnswerSituation(steId));
        Assert.assertTrue("1/2".equals(examPaperService.getAnswerSituation(steId)));
    }

    @Test
    // 获取已做题目和总题数 当获取不到用户正在做题的数据时
    public void getAnswerSituation_when_studentExamInProgressInfoIsNull()
    {
        StudentExamInProgressInfo studentExamInProgressInfo = ObjectFactory.getStudentExamInProgressInfo();
        Mockito.when(studentExamInProgressInfoDao.get(steId)).thenReturn(null);
        System.out.println(examPaperService.getAnswerSituation(steId));
        Assert.assertTrue(StringUtils.isEmpty(examPaperService.getAnswerSituation(steId)));
    }

    @Test
    // 得到所有试卷，正常数据测试
    public void getExamPaper()
    {
        // 试卷数据
        List<ExamPaper> examPapers = ObjectFactory.getExamPaper();
        Mockito.when(examPaperDao.getExamPaper(partnerId,courseId, startIndex, pageSize)).thenReturn(examPapers);
        Mockito.when(examPaperDao.getBuyExamPaper(partnerId,courseId, userId, startIndex, pageSize)).thenReturn(examPapers);
        List<ExamPaper> examPapersList = examPaperService.getExamPaper(partnerId,1, courseId, userId, startIndex, pageSize);
        Assert.assertTrue(examPapersList.size() == 2);
        examPapersList.forEach((o) -> System.out.println(o.getExamPaperId() + "--" + o.getExamPaperName()));
    }

    @Test
    // 得到所有试卷，当获取不到试卷数据时
    public void getExamPaperWhenExamPaperIsNull()
    {
        // 试卷数据
        List<ExamPaper> examPapers = ObjectFactory.getExamPaper();
        Mockito.when(examPaperDao.getExamPaper(partnerId,courseId, startIndex, pageSize)).thenReturn(null);
        Mockito.when(examPaperDao.getBuyExamPaper(partnerId,courseId, userId, startIndex, pageSize)).thenReturn(null);
        List<ExamPaper> examPapersList = examPaperService.getExamPaper(partnerId,1, courseId, userId, startIndex, pageSize);
        Assert.assertTrue(examPapersList.size() == 0);
        examPapersList.forEach((o) -> System.out.println(o.getExamPaperId() + "--" + o.getExamPaperName()));
    }

    @Test
    // 得到试卷状态和测试ID，正常数据测试
    public void getExamPaperStatus()
        throws Exception
    {
        // 试卷数据
        List<ExamPaper> examPapers = ObjectFactory.getExamPaper();
        Mockito.when(examPaperDao.getExamPaper(partnerId,courseId, startIndex, pageSize)).thenReturn(examPapers);
        Mockito.when(examPaperDao.getBuyExamPaper(partnerId,courseId, userId, startIndex, pageSize)).thenReturn(examPapers);
        // 获取用户所有模拟测试卷
        UserResourceList userResourceList = ObjectFactory.getUserResourceList();
        Mockito.when(userResourceDao.getUserResource(userId, CommonConst.EXAM_PAPER)).thenReturn(userResourceList);
        // 获取用户测试数据缓存
        StudentExamList studentExamList = ObjectFactory.getStudentExamList();
        Mockito.when(studentExamDao.getStudentExamList(userId)).thenReturn(studentExamList);
        StudentLastExamItem studentLastExamItem1 = examPaperService.getExamPaperLastExam(userResourceList,studentExamList, 1);
        StudentLastExamItem studentLastExamItem2 = examPaperService.getExamPaperLastExam(userResourceList, studentExamList,2);
        System.out.println(studentLastExamItem1.getStatus() + "-------------"+studentLastExamItem2.getStatus());
        System.out.println(studentLastExamItem1.getStudentExamId() + "-------------"+studentLastExamItem2.getStudentExamId());
        Assert.assertTrue(studentLastExamItem1.getStatus() - 3 == 0 && studentLastExamItem2.getStatus() - 4 == 0 );
    }

    @Test
    // 得到试卷状态和测试ID，当用户没有购买试卷时
    public void getExamPaperStatusWhenUserResourceIsNull()
            throws Exception
    {
        // 试卷数据
        List<ExamPaper> examPapers = ObjectFactory.getExamPaper();
        Mockito.when(examPaperDao.getExamPaper(partnerId,courseId, startIndex, pageSize)).thenReturn(examPapers);
        Mockito.when(examPaperDao.getBuyExamPaper(partnerId,courseId, userId, startIndex, pageSize)).thenReturn(examPapers);
        // 获取用户所有模拟测试卷
        UserResourceList userResourceList = ObjectFactory.getUserResourceList();
        Mockito.when(userResourceDao.getUserResource(userId, CommonConst.EXAM_PAPER)).thenReturn(null);
        // 获取用户测试数据缓存
        StudentExamList studentExamList = ObjectFactory.getStudentExamList();
        Mockito.when(studentExamDao.getStudentExamList(userId)).thenReturn(studentExamList);
        StudentLastExamItem studentLastExamItem1 = examPaperService.getExamPaperLastExam(null,studentExamList, 1);
        StudentLastExamItem studentLastExamItem2 = examPaperService.getExamPaperLastExam(null, studentExamList,2);
        System.out.println(studentLastExamItem1.getStatus() + "-------------"+studentLastExamItem2.getStatus());
        System.out.println(studentLastExamItem1.getStudentExamId() + "-------------"+studentLastExamItem2.getStudentExamId());
        Assert.assertTrue(studentLastExamItem1.getStatus() - 1 == 0 && studentLastExamItem2.getStatus() - 1 == 0 );
    }

    @Test
    // 得到试卷状态和测试ID，当用户已购买试卷，但没生成测试记录时
    public void getExamPaperStatusWhenStudentExamIsNull()
            throws Exception
    {
        // 试卷数据
        List<ExamPaper> examPapers = ObjectFactory.getExamPaper();
        Mockito.when(examPaperDao.getExamPaper(partnerId,courseId, startIndex, pageSize)).thenReturn(examPapers);
        Mockito.when(examPaperDao.getBuyExamPaper(partnerId,courseId, userId, startIndex, pageSize)).thenReturn(examPapers);
        // 获取用户所有模拟测试卷
        UserResourceList userResourceList = ObjectFactory.getUserResourceList();
        Mockito.when(userResourceDao.getUserResource(userId, CommonConst.EXAM_PAPER)).thenReturn(userResourceList);
        // 获取用户测试数据缓存
        StudentExamList studentExamList = ObjectFactory.getStudentExamList();
        Mockito.when(studentExamDao.getStudentExamList(userId)).thenReturn(studentExamList);
        StudentLastExamItem studentLastExamItem1 = examPaperService.getExamPaperLastExam(userResourceList,null, 1);
        StudentLastExamItem studentLastExamItem2 = examPaperService.getExamPaperLastExam(userResourceList, null,2);
        System.out.println(studentLastExamItem1.getStatus() + "-------------"+studentLastExamItem2.getStatus());
        System.out.println(studentLastExamItem1.getStudentExamId() + "-------------"+studentLastExamItem2.getStudentExamId());
        Assert.assertTrue(studentLastExamItem1.getStatus() - 2 == 0 && studentLastExamItem2.getStatus() - 2 == 0 );
    }

    /**
     * 获取试卷列表，返回到controller层，正常数据测试
     * 
     * @throws Exception
     */
    @Test
    public void getExamPaperList()
        throws Exception
    {
        // 试卷数据
        List<ExamPaper> examPapers = ObjectFactory.getExamPaper();
        Mockito.when(examPaperDao.getExamPaper(partnerId,courseId, startIndex, pageSize)).thenReturn(examPapers);
        Mockito.when(examPaperDao.getBuyExamPaper(partnerId,courseId, userId, startIndex, pageSize)).thenReturn(examPapers);
        // 获取用户所有模拟测试卷
        UserResourceList userResourceList = ObjectFactory.getUserResourceList();
        Mockito.when(userResourceDao.getUserResource(userId, CommonConst.EXAM_PAPER)).thenReturn(userResourceList);
        // 获取用户测试数据缓存
        StudentExamList studentExamList = ObjectFactory.getStudentExamList();
        Mockito.when(studentExamDao.getStudentExamList(userId)).thenReturn(studentExamList);
        // 获取用户正在做题的数据
        StudentExamInProgressInfo studentExamInProgressInfo = ObjectFactory.getStudentExamInProgressInfo();
        Mockito.when(studentExamInProgressInfoDao.get(steId)).thenReturn(studentExamInProgressInfo);
        //测评数据
        StudentExamResult studentExamResult = ObjectFactory.getStudentExamResult();
        Mockito.when(studentExamResultDao.get(steId)).thenReturn(studentExamResult);

        ExamPaperListModule examPaperListModule = examPaperService.getExamPaperList(partnerId,1, courseId, userId, startIndex, pageSize);
        examPaperListModule.getPaperList().forEach((o) -> System.out.println(o.getSteId() + "---" + o.getExamPaperName() + "----" + o.getStatus() + "----" + o.getAnswerSituation()+"----得分"+o.getScore()));
        Assert.assertTrue(examPaperListModule.getPaperList().get(0).getStatus()==3 &&  examPaperListModule.getPaperList().get(1).getStatus() == 4);
    }

    /**
     * 获取试卷详情正常数据测试
     */
    @Test
    public void get(){
        ExamPaper examPaper = ObjectFactory.getExamPaperObject();
        Mockito.when(examPaperDao.get(examPaperId)).thenReturn(examPaper);
        ExamPaperDetailModule examPaperDetailModule = examPaperService.get(userId,examPaperId);
        Assert.assertTrue(examPaperDetailModule.getIsFree() == true && examPaperDetailModule.getExamMethod().equals("闭卷"));
    }

    /**
     * 获取试卷详情正常数据测试，当试卷不存在时
     */
    @Test
    public void getWhenExamPaperIdIsNull(){
        ExamPaper examPaper = ObjectFactory.getExamPaperObject();
        Mockito.when(examPaperDao.get(examPaperId)).thenReturn(null);
        ExamPaperDetailModule examPaperDetailModule = examPaperService.get(userId,examPaperId);
        Assert.assertTrue(examPaperDetailModule == null);
    }

}
