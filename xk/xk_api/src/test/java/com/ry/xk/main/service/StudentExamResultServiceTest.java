package com.ry.xk.main.service;

import com.alibaba.fastjson.JSON;
import com.ry.xk.Application;
import com.ry.xk.common.CommonConst;
import com.ry.xk.main.bo.PartnerExtension;
import com.ry.xk.response.bo.AnalysisAnswerSheets;
import com.ry.xk.response.bo.ExamResultModule;
import com.ry.xk.studentexamresult.bo.ExamSet;
import com.ry.xk.studentexamresult.bo.ExamSetQuestion;
import com.ry.xk.studentexamresult.bo.StudentExam;
import com.ry.xk.studentexamresult.bo.StudentExamResult;
import com.ry.xk.studentexamresult.dao.IExamSetDao;
import com.ry.xk.studentexamresult.dao.IShareDao;
import com.ry.xk.studentexamresult.dao.IStudentExamDao;
import com.ry.xk.studentexamresult.dao.IStudentExamResultDao;
import com.ry.xk.studentexamresult.service.IExamService;
import com.ry.xk.studentexamresult.service.IStudentExamResultService;
import org.junit.Assert;
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
public class StudentExamResultServiceTest {

    int studentExamId = 100;
    int examSetId = 1;
    int userId = 1;
    int courseId = 1;
    @Mock
    IStudentExamResultDao studentExamResultDao;
    @Mock
    IExamService examService;
    @Mock
    IExamSetDao examSetDao;
    @Mock
    IStudentExamDao studentExamDao;

    @Autowired
    @InjectMocks
    IStudentExamResultService studentExamResultService;

    @Test
    //测试获取试卷的测评结果，正常数据
    public void getExamResult() throws Exception{
        Mockito.when(examService.validateExamAndUser(userId, studentExamId)).thenReturn(true);
        StudentExam studentExam = new StudentExam();
        studentExam.setCourseId(courseId);

        Mockito.when(studentExamDao.getStudentExam(studentExamId)).thenReturn(studentExam);
        StudentExamResult studentExamResult = ObjectFactory.getStudentExamResult();
        Mockito.when(studentExamResultDao.get(studentExamId)).thenReturn(studentExamResult);
        ExamResultModule examResultModule = studentExamResultService.getExamResult(userId,studentExamId);
        Assert.assertTrue(examResultModule.getScore() == 95.3 &&
                examResultModule.getKnowledgePointResults().get(0).getKnowledgePointName().equals("知识点一") &&
                examResultModule.getKnowledgePointResults().get(1).getKnowledgePointName().equals("知识点二"));
    }

    @Test
    //测试获取试卷的测评结果，当测评结果不存在时
    public void getExamResultWhenExamResultIsNull() throws Exception{
        Mockito.when(examService.validateExamAndUser(userId, studentExamId)).thenReturn(true);
        StudentExam studentExam = new StudentExam();
        studentExam.setCourseId(courseId);

        Mockito.when(studentExamDao.getStudentExam(studentExamId)).thenReturn(studentExam);
        StudentExamResult studentExamResult = null;
        Mockito.when(studentExamResultDao.get(studentExamId)).thenReturn(studentExamResult);
        ExamResultModule examResultModule = studentExamResultService.getExamResult(userId,studentExamId);
        Assert.assertTrue(examResultModule == null);
    }

    /**
     * 获取试卷解析
     */
    @Test
    public void getAnalysisAnswerSheets() throws Exception{
        StudentExamResult studentExamResult = ObjectFactory.getStudentExamResult();
        Mockito.when(examService.validateExamAndUser(userId, studentExamId)).thenReturn(true);
        Mockito.when(studentExamResultDao.get(studentExamId)).thenReturn(studentExamResult);
        StudentExam studentExam = new StudentExam();
        studentExam.setExamSetId(examSetId);
        Mockito.when(studentExamDao.getStudentExam(studentExamId)).thenReturn(studentExam);

        ExamSet examSet = new ExamSet();

        ExamSetQuestion examSetQuestion1 = new ExamSetQuestion();
        examSetQuestion1.setOrderIndex(2);
        examSetQuestion1.setQuestionId(1);

        ExamSetQuestion examSetQuestion2 = new ExamSetQuestion();
        examSetQuestion2.setOrderIndex(1);
        examSetQuestion2.setQuestionId(2);
        List<ExamSetQuestion> examSetQuestions = new ArrayList<ExamSetQuestion>();
        examSetQuestions.add(examSetQuestion1);
        examSetQuestions.add(examSetQuestion2);

        examSet.setExamSetQuestions(examSetQuestions);

        Mockito.when(examSetDao.getExamSet(examSetId)).thenReturn(examSet);

        List<AnalysisAnswerSheets> analysisAnswerSheets = studentExamResultService.getAnalysisAnswerSheets(userId,studentExamId);
        Assert.assertTrue(analysisAnswerSheets.get(1).getQuestionCorrectStatus() == CommonConst.PGZQ && analysisAnswerSheets.get(0).getQuestionCorrectStatus() == CommonConst.PGCY);
        analysisAnswerSheets.forEach(o->System.out.println(o.getOrderIndex()+"-----------"+o.getQuestionId()));
    }
}
