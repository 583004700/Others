package com.ry.xk.main.service;

import com.ry.xk.common.CommonConst;
import com.ry.xk.common.bo.CommonDictionary;
import com.ry.xk.main.bo.Course;
import com.ry.xk.main.bo.Partner;
import com.ry.xk.main.bo.PartnerCourseMapping;
import com.ry.xk.studentexamresult.bo.*;
import com.ry.xk.utils.DateUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ObjectFactory
{
    /**
     * 获取公共字典数据
     * 
     * @return
     */
    public static List<CommonDictionary> getCommonDictionary()
    {
        List<CommonDictionary> commonDictionaries = new ArrayList<CommonDictionary>();
        CommonDictionary c1 = new CommonDictionary();
        c1.setItemKey(1);
        c1.setItemValue("小学");
        c1.setItemGroup("CourseType");
        c1.setOrderIndex(1);

        CommonDictionary c2 = new CommonDictionary();
        c2.setItemKey(2);
        c2.setItemValue("初中");
        c2.setItemGroup("CourseType");
        c2.setOrderIndex(2);

        CommonDictionary c3 = new CommonDictionary();
        c3.setItemKey(3);
        c3.setItemValue("高中");
        c3.setItemGroup("CourseType");
        c3.setOrderIndex(3);
        commonDictionaries.add(c3);
        commonDictionaries.add(c2);
        commonDictionaries.add(c1);
        return commonDictionaries;
    }

    /**
     * 获取学科映射
     * 
     * @return
     */
    public static List<PartnerCourseMapping> getPartnerCourseMapping()
    {
        List<PartnerCourseMapping> partnerCourseMappings = new ArrayList<PartnerCourseMapping>();
        PartnerCourseMapping partnerCourseMapping1 = new PartnerCourseMapping();
        partnerCourseMapping1.setCourseTypeId(1);
        partnerCourseMapping1.setCourseId(1);

        PartnerCourseMapping partnerCourseMapping2 = new PartnerCourseMapping();
        partnerCourseMapping2.setCourseTypeId(2);
        partnerCourseMapping2.setCourseId(1);

        PartnerCourseMapping partnerCourseMapping3 = new PartnerCourseMapping();
        partnerCourseMapping3.setCourseTypeId(2);
        partnerCourseMapping3.setCourseId(3);

        partnerCourseMappings.add(partnerCourseMapping1);
        partnerCourseMappings.add(partnerCourseMapping2);
        partnerCourseMappings.add(partnerCourseMapping3);
        return partnerCourseMappings;
    }

    /**
     * 获取partner
     * 
     * @return
     */
    public static Partner getPartner()
    {
        Partner partner = new Partner();
        partner.setPartnerId(1);
        partner.setPartnerName("腾讯");
        partner.setPartnerCourseMappings(getPartnerCourseMapping());
        return partner;
    }

    /**
     * 获取学科
     * 
     * @return
     */
    public static List<Course> getCourses()
    {
        List<Course> courses = new ArrayList<Course>();
        Course course1 = new Course();
        course1.setCourseId(1);
        course1.setCourseTypeId(1);
        course1.setCourseName("数学");

        Course course2 = new Course();
        course2.setCourseTypeId(2);
        course2.setCourseId(2);
        course2.setCourseName("英语");

        Course course3 = new Course();
        course3.setCourseId(3);
        course3.setCourseTypeId(2);
        course3.setCourseName("语文");

        courses.add(course3);
        courses.add(course2);
        courses.add(course1);
        return courses;
    }

    /**
     * 获取试卷
     * 
     * @return
     */
    public static List<ExamPaper> getExamPaper()
    {
        ExamPaper examPaper1 = new ExamPaper();
        examPaper1.setCourseId(1);
        examPaper1.setExamPaperCoverPath("15488");
        examPaper1.setExamPaperId(1);
        examPaper1.setExamPaperName("第一张试卷");
        examPaper1.setIsFree(1);
        examPaper1.setPrice(30.55f);

        ExamPaper examPaper2 = new ExamPaper();
        examPaper2.setCourseId(1);
        examPaper2.setExamPaperCoverPath("15487");
        examPaper2.setExamPaperId(2);
        examPaper2.setExamPaperName("第二张试卷");
        examPaper2.setIsFree(0);
        examPaper2.setPrice(36.55f);

        List<ExamPaper> examPapers = new ArrayList<ExamPaper>();
        examPapers.add(examPaper1);
        examPapers.add(examPaper2);
        return examPapers;
    }

    /**
     * 获取用户资源缓存
     */
    public static UserResourceList getUserResourceList()
    {
        UserResourceList userResourceList = new UserResourceList();
        userResourceList.setResourceTypeId(1);
        userResourceList.setUserId(1);
        List<UserResource> userResources = new ArrayList<UserResource>();
        userResourceList.setUserResource(userResources);

        UserResource userResource1 = new UserResource();
        userResource1.setResourceId(1);
        userResource1.setResourceTypeId(CommonConst.EXAM_PAPER);

        UserResource userResource2 = new UserResource();
        userResource2.setResourceId(2);
        userResource2.setResourceTypeId(CommonConst.EXAM_PAPER);
        userResources.add(userResource1);
        userResources.add(userResource2);

        return userResourceList;
    }

    /**
     * 得到用户测试的缓存数据
     * 
     * @return
     */
    public static StudentExamList getStudentExamList()
        throws Exception
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        StudentExamList studentExamList = new StudentExamList();
        studentExamList.setUserId(1);
        List<StudentExamItem> studentExams = new ArrayList<StudentExamItem>();
        studentExamList.setStudentExamItems(studentExams);
        StudentExamItem studentExam1 = new StudentExamItem();
        studentExam1.setExamPaperId(1);
        studentExam1.setUserId(1);
        studentExam1.setStudentExamId(100);
        studentExam1.setCreateDateTime(sdf.parse("2018-07-01"));
        studentExam1.setEndDateTime(sdf.parse("2018-07-02"));
        studentExam1.setIsGenerateEvaluation(true);

        StudentExamItem studentExam2 = new StudentExamItem();
        studentExam2.setExamPaperId(2);
        studentExam2.setUserId(1);
        studentExam2.setStudentExamId(200);

        Date date = sdf.parse("2018-07-20");
        studentExam2.setEndDateTime(date);

        studentExamList.getStudentExamItems().add(studentExam1);
        studentExamList.getStudentExamItems().add(studentExam2);
        return studentExamList;
    }

    /**
     * 获取学生正在做题的情况
     * 
     * @return
     */
    public static StudentExamInProgressInfo getStudentExamInProgressInfo()
    {
        StudentExamInProgressInfo studentExamInProgressInfo = new StudentExamInProgressInfo();
        studentExamInProgressInfo.setLastQuestionId(11);
        List<StudentExamProgressQuestion> studentExamProgressQuestions = new ArrayList<StudentExamProgressQuestion>();
        studentExamInProgressInfo.setExamDoingQuestions(studentExamProgressQuestions);

        StudentExamProgressQuestion studentExamProgressQuestion1 = new StudentExamProgressQuestion();
        studentExamProgressQuestion1.setStudentAnswer("A");
        StudentExamProgressQuestion studentExamProgressQuestion2 = new StudentExamProgressQuestion();
        studentExamInProgressInfo.getExamDoingQuestions().add(studentExamProgressQuestion1);
        studentExamInProgressInfo.getExamDoingQuestions().add(studentExamProgressQuestion2);
        return studentExamInProgressInfo;
    }

    /**
     * 学生测试结果数据
     * 
     * @return
     */
    public static StudentExamResult getStudentExamResult()
    {
        StudentExamResult studentExamResult = new StudentExamResult();
        studentExamResult.setScore(95.3);
        studentExamResult.setStudentExamId(100);
        studentExamResult.setPassExamProbability(93.5);
        List<ExamReviewSummaryView> examReviewSummaryViews = new ArrayList<ExamReviewSummaryView>();
        studentExamResult.setExamReviewSummaryViews(examReviewSummaryViews);
        ExamReviewSummaryView examReviewSummaryView1 = new ExamReviewSummaryView();
        examReviewSummaryView1.setKnowledgePointId(1);
        examReviewSummaryView1.setKnowledgePointName("知识点一");
        examReviewSummaryView1.setStudentAccuracy(77);
        ExamReviewSummaryView examReviewSummaryView2 = new ExamReviewSummaryView();
        examReviewSummaryView2.setKnowledgePointId(2);
        examReviewSummaryView2.setKnowledgePointName("知识点二");
        examReviewSummaryView2.setStudentAccuracy(80);
        examReviewSummaryViews.add(examReviewSummaryView1);
        examReviewSummaryViews.add(examReviewSummaryView2);

        List<StudentQuestion> studentQuestions = new ArrayList<StudentQuestion>();
        studentExamResult.setQuestions(studentQuestions);
        StudentQuestion studentQuestion1 = new StudentQuestion();
        studentQuestion1.setIsCorrect(true);
        studentQuestion1.setQuestionId(1);

        StudentQuestion studentQuestion2 = new StudentQuestion();
        studentQuestion2.setIsCorrect(false);
        studentQuestion2.setQuestionId(2);
        studentQuestions.add(studentQuestion1);
        studentQuestions.add(studentQuestion2);
        return studentExamResult;
    }

    /**
     * 试卷数据
     */
    public static ExamPaper getExamPaperObject()
    {
        ExamPaper examPaper = new ExamPaper();
        examPaper.setCourseId(1);
        examPaper.setExamPaperCoverPath("15488");
        examPaper.setExamPaperId(1);
        examPaper.setExamPaperName("第一张试卷");
        examPaper.setIsFree(1);
        examPaper.setPrice(30.55f);
        examPaper.setIsFree(1);
        examPaper.setExamType(1);
        examPaper.setExpireTime(new Date());
        return examPaper;
    }

    public static WrongBook getWrongBook()
        throws Exception
    {
        WrongBook wrongBook = new WrongBook();
        wrongBook.setUserId(1);
        wrongBook.setCourseId(1);
        List<WrongQuestion> wrongQuestions = new ArrayList<WrongQuestion>();
        wrongBook.setWrongQuestions(wrongQuestions);
        WrongQuestion wrongQuestion1 = new WrongQuestion();
        wrongQuestion1.setQuestionId(15);
        wrongQuestion1.setCreateTime(DateUtil.parse("2018/06/06", "yyyy/MM/dd"));

        WrongQuestion wrongQuestion2 = new WrongQuestion();
        wrongQuestion2.setQuestionId(16);
        wrongQuestion2.setCreateTime(DateUtil.parse("2018/06/07", "yyyy/MM/dd"));
        wrongQuestions.add(wrongQuestion1);
        wrongQuestions.add(wrongQuestion2);
        return wrongBook;
    }

}
