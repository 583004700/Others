package com.ry.xk.main.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.never;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

import com.ry.xk.Application;
import com.ry.xk.common.CommonConst;
import com.ry.xk.request.bo.GenerateExamDataRequest;
import com.ry.xk.studentexamresult.bo.ExamPaper;
import com.ry.xk.studentexamresult.bo.ExamPaperQuestion;
import com.ry.xk.studentexamresult.bo.ExamSet;
import com.ry.xk.studentexamresult.bo.StudentExam;
import com.ry.xk.studentexamresult.bo.StudentExamInProgressInfo;
import com.ry.xk.studentexamresult.bo.StudentExamItem;
import com.ry.xk.studentexamresult.bo.StudentExamList;
import com.ry.xk.studentexamresult.bo.UserResource;
import com.ry.xk.studentexamresult.bo.UserResourceList;
import com.ry.xk.studentexamresult.dao.IExamPaperDao;
import com.ry.xk.studentexamresult.dao.IExamSetDao;
import com.ry.xk.studentexamresult.dao.IStudentExamDao;
import com.ry.xk.studentexamresult.dao.IStudentExamInProgressInfoDao;
import com.ry.xk.studentexamresult.dao.IUserResourceDao;
import com.ry.xk.studentexamresult.service.IGenerateExamDataService;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class GenerateExamDataServiceTest
{
    @Mock
    IUserResourceDao userResourceDao;

    @Mock
    IStudentExamDao studentExamDao;

    @Mock
    IExamSetDao examSetDao;

    @Mock
    IExamPaperDao examPaperDao;

    @Mock
    IStudentExamInProgressInfoDao studentExamInProgressInfoDao;

    GenerateExamDataRequest request;

    UserResourceList resourceListObj;

    UserResource userResource;

    List<UserResource> userResources;

    StudentExamList studentExamList;

    List<StudentExamItem> studentExamItems;

    StudentExamItem studentExamItem;

    ExamPaper examPaper;

    List<ExamPaperQuestion> examPaperQuestions;

    ExamPaperQuestion examPaperQuestion;

    @Before
    public void setUp()
        throws Exception
    {
        MockitoAnnotations.initMocks(this);
        request = new GenerateExamDataRequest();
        request.setUserId(10);
        request.setPartnerId(5);

        resourceListObj = new UserResourceList();
        resourceListObj.setUserId(10);
        resourceListObj.setResourceTypeId(1);

        userResource = new UserResource();
        userResource.setResourceId(10);

        userResources = new ArrayList<UserResource>();

        studentExamList = new StudentExamList();
        studentExamList.setUserId(5);

        studentExamItems = new ArrayList<StudentExamItem>();

        studentExamItem = new StudentExamItem();
        studentExamItem.setUserId(5);
        studentExamItem.setExamPaperId(10);
        studentExamItem.setStudentExamId(100);

        examPaper = new ExamPaper();
        examPaper.setCourseId(1);
        examPaper.setExamPaperId(10);

        examPaperQuestions = new ArrayList<ExamPaperQuestion>();

        examPaperQuestion = new ExamPaperQuestion();
        examPaperQuestion.setExamPaperId(10);
        examPaperQuestion.setQuestionId(2);
        examPaperQuestion.setQuestionScore(3);
        examPaperQuestion.setOrderIndex(1);
    }

    @Autowired
    @InjectMocks
    IGenerateExamDataService examService;

    /**
     * 试卷解析失败
     * 
     * @Title: getTokenStrSuccess
     * @author 幸仁强
     * @throws Exception
     */
    @Test
    public void checkAndGenerateExamDataWhenParamsAnalysisFail()
        throws Exception
    {
        request.setExamPaperId("yrSkYPv4E20%3");
        long studentExamId = examService.checkAndGenerateExamData(request);
        Mockito.verify(userResourceDao, never()).getUserResource(Mockito.any(Integer.class), Mockito.any(Integer.class));
        assertTrue(studentExamId == 0);;
    }

    /**
     * 用户没有购买任何试卷
     * 
     * @Title: checkAndGenerateExamDataWhenAllExamPaperNotBuy
     * @author 幸仁强
     * @throws Exception
     */
    @Test
    public void checkAndGenerateExamDataWhenAllExamPaperNotBuy()
        throws Exception
    {
        request.setExamPaperId("yrSkYPv4E20%3D");
        Mockito.when(userResourceDao.getUserResource(Mockito.any(Integer.class), Mockito.any(Integer.class))).thenReturn(null);
        long studentExamId = examService.checkAndGenerateExamData(request);
        Mockito.verify(userResourceDao).getUserResource(Mockito.any(Integer.class), Mockito.any(Integer.class));
        assertTrue(studentExamId == 0);;
    }

    /**
     * 用户没有购买传入ID的试卷
     * 
     * @Title: checkAndGenerateExamDataWhenThisExamPaperNotBuy
     * @author 幸仁强
     * @throws Exception
     */
    @Test
    public void checkAndGenerateExamDataWhenThisExamPaperNotBuy()
        throws Exception
    {
        request.setExamPaperId("yrSkYPv4E20%3D");
        userResource.setStatusFlag(CommonConst.STATUS_FLAG_INVALID);
        userResources.add(userResource);
        resourceListObj.setUserResource(userResources);
        Mockito.when(userResourceDao.getUserResource(Mockito.any(Integer.class), Mockito.any(Integer.class))).thenReturn(resourceListObj);
        long studentExamId = examService.checkAndGenerateExamData(request);
        Mockito.verify(userResourceDao).getUserResource(Mockito.any(Integer.class), Mockito.any(Integer.class));
        Mockito.verify(studentExamDao, never()).getStudentExamList(Mockito.any(Integer.class));
        assertTrue(studentExamId == 0);;
    }

    /**
     * 用户从来没有测试过，测试记录缓存数据为空
     * 
     * @Title: checkAndGenerateExamDataWhenNotExistDoingExamPaper
     * @author 幸仁强
     * @throws Exception
     */
    @Test
    public void checkAndGenerateExamDataWhenNeverExam()
        throws Exception
    {
        request.setExamPaperId("yrSkYPv4E20%3D");
        userResource.setStatusFlag(CommonConst.STATUS_FLAG_VALID);
        userResources.add(userResource);
        resourceListObj.setUserResource(userResources);
        Mockito.when(userResourceDao.getUserResource(Mockito.any(Integer.class), Mockito.any(Integer.class))).thenReturn(resourceListObj);
        Mockito.when(studentExamDao.getStudentExamList(Mockito.any(Integer.class))).thenReturn(null);
        Mockito.when(examPaperDao.get(Mockito.any(Integer.class))).thenReturn(null);
        long studentExamId = examService.checkAndGenerateExamData(request);
        Mockito.verify(studentExamDao).getStudentExamList(Mockito.any(Integer.class));
        Mockito.verify(examPaperDao).get(Mockito.any(Integer.class));
        assertTrue(studentExamId == 0);;
    }

    /**
     * 用户有测试过，但是传入当前试卷ID未匹配到正在测试的数据且根据试卷ID未查询到试卷信息
     * 
     * @Title: checkAndGenerateExamDataWhenNotExistDoingExamPaper
     * @author 幸仁强
     * @throws Exception
     */
    @Test
    public void checkAndGenerateExamDataWhenNotExsitDoingExamPaperAndExamPaperNotExsit()
        throws Exception
    {
        request.setExamPaperId("yrSkYPv4E20%3D");
        userResource.setStatusFlag(CommonConst.STATUS_FLAG_VALID);
        userResources.add(userResource);
        resourceListObj.setUserResource(userResources);
        Mockito.when(userResourceDao.getUserResource(Mockito.any(Integer.class), Mockito.any(Integer.class))).thenReturn(resourceListObj);
        studentExamItem.setCreateDateTime(new Date());
        studentExamItem.setEndDateTime(new Date());
        studentExamItem.setIsGenerateEvaluation(false);
        studentExamItems.add(studentExamItem);
        studentExamList.setStudentExamItems(studentExamItems);
        Mockito.when(studentExamDao.getStudentExamList(Mockito.any(Integer.class))).thenReturn(studentExamList);
        Mockito.when(examPaperDao.get(Mockito.any(Integer.class))).thenReturn(null);
        long studentExamId = examService.checkAndGenerateExamData(request);
        Mockito.verify(studentExamDao).getStudentExamList(Mockito.any(Integer.class));
        Mockito.verify(examPaperDao).get(Mockito.any(Integer.class));
        assertTrue(studentExamId == 0);;
    }

    /**
     * 用户传入当前试卷ID匹配到正在测试的数据，返回测试ID
     * 
     * @Title: checkAndGenerateExamDataWhenExsitDoingExamPaper
     * @author 幸仁强
     * @throws Exception
     */
    @Test
    public void checkAndGenerateExamDataWhenExsitDoingExamPaper()
        throws Exception
    {
        request.setExamPaperId("yrSkYPv4E20%3D");
        userResource.setStatusFlag(CommonConst.STATUS_FLAG_VALID);
        userResources.add(userResource);
        resourceListObj.setUserResource(userResources);
        Mockito.when(userResourceDao.getUserResource(Mockito.any(Integer.class), Mockito.any(Integer.class))).thenReturn(resourceListObj);
        Calendar nowTime = Calendar.getInstance();
        studentExamItem.setCreateDateTime(nowTime.getTime());
        nowTime.add(Calendar.YEAR, 50);
        studentExamItem.setEndDateTime(nowTime.getTime());
        studentExamItem.setIsGenerateEvaluation(false);
        studentExamItems.add(studentExamItem);
        studentExamList.setStudentExamItems(studentExamItems);
        Mockito.when(studentExamDao.getStudentExamList(Mockito.any(Integer.class))).thenReturn(studentExamList);
        Mockito.when(examPaperDao.get(Mockito.any(Integer.class))).thenReturn(null);
        long studentExamId = examService.checkAndGenerateExamData(request);
        Mockito.verify(studentExamDao).getStudentExamList(Mockito.any(Integer.class));
        Mockito.verify(examPaperDao, never()).get(Mockito.any(Integer.class));
        assertTrue(studentExamId > 0);;
    }

    /**
     * 用户有测试过，但是传入当前试卷ID未匹配到正在测试的数据,查询到试卷但是没有题目
     * 
     * @Title: checkAndGenerateExamDataWhenNotExistDoingExamPaper
     * @author 幸仁强
     * @throws Exception
     */
    @Test
    public void checkAndGenerateExamDataWhenNotExsitDoingExamPaperGetExamPaperButNotExistQuestion()
        throws Exception
    {
        request.setExamPaperId("yrSkYPv4E20%3D");
        userResource.setStatusFlag(CommonConst.STATUS_FLAG_VALID);
        userResources.add(userResource);
        resourceListObj.setUserResource(userResources);
        Mockito.when(userResourceDao.getUserResource(Mockito.any(Integer.class), Mockito.any(Integer.class))).thenReturn(resourceListObj);
        studentExamItem.setCreateDateTime(new Date());
        studentExamItem.setEndDateTime(new Date());
        studentExamItem.setIsGenerateEvaluation(false);
        studentExamItems.add(studentExamItem);
        studentExamList.setStudentExamItems(studentExamItems);
        Mockito.when(studentExamDao.getStudentExamList(Mockito.any(Integer.class))).thenReturn(studentExamList);
        Mockito.when(examPaperDao.get(Mockito.any(Integer.class))).thenReturn(examPaper);
        long studentExamId = examService.checkAndGenerateExamData(request);
        Mockito.verify(examPaperDao).get(Mockito.any(Integer.class));
        Mockito.verify(examSetDao, never()).insertExamSet(Mockito.any(ExamSet.class));
        assertTrue(studentExamId == 0);;
    }

    /**
     * 用户有测试过，但是传入当前试卷ID未匹配到正在测试的数据,查询到试卷且有题目,但是生成题集时失败了
     * 
     * @Title: checkAndGenerateExamDataWhenNotExistDoingExamPaper
     * @author 幸仁强
     * @throws Exception
     */
    @Test
    public void checkAndGenerateExamDataWhenGenerateExamSetFail()
        throws Exception
    {
        request.setExamPaperId("yrSkYPv4E20%3D");
        userResource.setStatusFlag(CommonConst.STATUS_FLAG_VALID);
        userResources.add(userResource);
        resourceListObj.setUserResource(userResources);
        Mockito.when(userResourceDao.getUserResource(Mockito.any(Integer.class), Mockito.any(Integer.class))).thenReturn(resourceListObj);
        studentExamItem.setCreateDateTime(new Date());
        studentExamItem.setEndDateTime(new Date());
        studentExamItem.setIsGenerateEvaluation(false);
        studentExamItems.add(studentExamItem);
        studentExamList.setStudentExamItems(studentExamItems);
        Mockito.when(studentExamDao.getStudentExamList(Mockito.any(Integer.class))).thenReturn(studentExamList);
        examPaperQuestions.add(examPaperQuestion);
        examPaper.setExampaperquestion(examPaperQuestions);
        Mockito.when(examPaperDao.get(Mockito.any(Integer.class))).thenReturn(examPaper);
        Mockito.when(examSetDao.insertExamSet(Mockito.any(ExamSet.class))).thenReturn(0);
        long studentExamId = examService.checkAndGenerateExamData(request);
        Mockito.verify(examSetDao).insertExamSet(Mockito.any(ExamSet.class));
        Mockito.verify(examSetDao, never()).updateExamSet(Mockito.any(ExamSet.class));
        assertTrue(studentExamId == 0);

    }

    /**
     * 用户有测试过，但是传入当前试卷ID未匹配到正在测试的数据,查询到试卷且有题目,但是生成题集成功了，但是生成学生测试表数据失败了
     * 
     * @Title: checkAndGenerateExamDataWhenNotExistDoingExamPaper
     * @author 幸仁强
     * @throws Exception
     */
    @Test
    public void checkAndGenerateExamDataWhenGenerateExamSetQuestionFail()
        throws Exception
    {
        request.setExamPaperId("yrSkYPv4E20%3D");
        userResource.setStatusFlag(CommonConst.STATUS_FLAG_VALID);
        userResources.add(userResource);
        resourceListObj.setUserResource(userResources);
        Mockito.when(userResourceDao.getUserResource(Mockito.any(Integer.class), Mockito.any(Integer.class))).thenReturn(resourceListObj);
        studentExamItem.setCreateDateTime(new Date());
        studentExamItem.setEndDateTime(new Date());
        studentExamItem.setIsGenerateEvaluation(false);
        studentExamItems.add(studentExamItem);
        studentExamList.setStudentExamItems(studentExamItems);
        Mockito.when(studentExamDao.getStudentExamList(Mockito.any(Integer.class))).thenReturn(studentExamList);
        examPaperQuestions.add(examPaperQuestion);
        examPaper.setExampaperquestion(examPaperQuestions);
        Mockito.when(examPaperDao.get(Mockito.any(Integer.class))).thenReturn(examPaper);
        Mockito.when(examSetDao.insertExamSet(Mockito.any(ExamSet.class))).thenReturn(1);
        Mockito.when(examSetDao.updateExamSet(Mockito.any(ExamSet.class))).thenReturn(false);
        long studentExamId = examService.checkAndGenerateExamData(request);
        Mockito.verify(examSetDao).updateExamSet(Mockito.any(ExamSet.class));
        Mockito.verify(studentExamDao, never()).insertStudentExam(Mockito.any(StudentExam.class));
        assertTrue(studentExamId == 0);;
    }

    /**
     * 用户有测试过，但是传入当前试卷ID未匹配到正在测试的数据,查询到试卷且有题目,但是生成题集成功了，但是生成学生测试表数据失败了
     * 
     * @Title: checkAndGenerateExamDataWhenNotExistDoingExamPaper
     * @author 幸仁强
     * @throws Exception
     */
    @Test
    public void checkAndGenerateExamDataWhenGenerateStudentExamFail()
        throws Exception
    {
        request.setExamPaperId("yrSkYPv4E20%3D");
        userResource.setStatusFlag(CommonConst.STATUS_FLAG_VALID);
        userResources.add(userResource);
        resourceListObj.setUserResource(userResources);
        Mockito.when(userResourceDao.getUserResource(Mockito.any(Integer.class), Mockito.any(Integer.class))).thenReturn(resourceListObj);
        studentExamItem.setCreateDateTime(new Date());
        studentExamItem.setEndDateTime(new Date());
        studentExamItem.setIsGenerateEvaluation(false);
        studentExamItems.add(studentExamItem);
        studentExamList.setStudentExamItems(studentExamItems);
        Mockito.when(studentExamDao.getStudentExamList(Mockito.any(Integer.class))).thenReturn(studentExamList);
        examPaperQuestions.add(examPaperQuestion);
        examPaper.setExampaperquestion(examPaperQuestions);
        Mockito.when(examPaperDao.get(Mockito.any(Integer.class))).thenReturn(examPaper);
        Mockito.when(examSetDao.insertExamSet(Mockito.any(ExamSet.class))).thenReturn(1);
        Mockito.when(examSetDao.updateExamSet(Mockito.any(ExamSet.class))).thenReturn(true);
        Mockito.when(studentExamDao.insertStudentExam(Mockito.any(StudentExam.class))).thenReturn(0L);
        long studentExamId = examService.checkAndGenerateExamData(request);
        Mockito.verify(studentExamDao).insertStudentExam(Mockito.any(StudentExam.class));
        Mockito.verify(studentExamInProgressInfoDao, never()).update(Mockito.any(StudentExamInProgressInfo.class));
        assertTrue(studentExamId == 0);;
    }

    /**
     * 成功生成数据并返回
     * 
     * @Title: checkAndGenerateExamDataSuccess
     * @author 幸仁强
     * @throws Exception
     */
    @Test
    public void checkAndGenerateExamDataSuccess()
        throws Exception
    {
        request.setExamPaperId("yrSkYPv4E20%3D");
        userResource.setStatusFlag(CommonConst.STATUS_FLAG_VALID);
        userResources.add(userResource);
        resourceListObj.setUserResource(userResources);
        Mockito.when(userResourceDao.getUserResource(Mockito.any(Integer.class), Mockito.any(Integer.class))).thenReturn(resourceListObj);
        studentExamItem.setCreateDateTime(new Date());
        studentExamItem.setEndDateTime(new Date());
        studentExamItem.setIsGenerateEvaluation(false);
        studentExamItems.add(studentExamItem);
        studentExamList.setStudentExamItems(studentExamItems);
        Mockito.when(studentExamDao.getStudentExamList(Mockito.any(Integer.class))).thenReturn(studentExamList);
        examPaperQuestions.add(examPaperQuestion);
        examPaper.setExampaperquestion(examPaperQuestions);
        Mockito.when(examPaperDao.get(Mockito.any(Integer.class))).thenReturn(examPaper);
        Mockito.when(examSetDao.insertExamSet(Mockito.any(ExamSet.class))).thenReturn(1);
        Mockito.when(examSetDao.updateExamSet(Mockito.any(ExamSet.class))).thenReturn(true);
        Mockito.when(studentExamDao.insertStudentExam(Mockito.any(StudentExam.class))).thenReturn(1L);
        long studentExamId = examService.checkAndGenerateExamData(request);
        Mockito.verify(studentExamDao).insertStudentExam(Mockito.any(StudentExam.class));
        Mockito.verify(studentExamDao).updateStudentExamList(Mockito.any(StudentExamList.class));
        assertTrue(studentExamId > 0);;
    }
}
