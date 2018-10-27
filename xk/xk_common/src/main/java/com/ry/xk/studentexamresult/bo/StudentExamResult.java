package com.ry.xk.studentexamresult.bo;

import java.util.Date;
import java.util.List;

import com.ry.xk.springbootframe.couchbase.CouchBaseSectionType;
import com.ry.xk.springbootframe.couchbase.ICouchBaseStoredObject;

import io.protostuff.Tag;

/**
 * 用户测试结果
 * 
 * @ClassName: StudentExamResult
 * @author 幸仁强
 * @date 2018年5月30日
 */
public class StudentExamResult implements ICouchBaseStoredObject
{
    // 用户ID
    @Tag(1)
    private int userId;

    // 测试ID
    @Tag(2)
    private long studentExamId;

    // 教材版本
    @Tag(3)
    private int bookVersionId;

    // 题目链
    @Tag(4)
    private List<StudentQuestion> questions;

    // 得分
    @Tag(5)
    private double score;

    // 正确题的数量
    @Tag(6)
    private int correctQuestionCount;

    // 错误题的数量
    @Tag(7)
    private int wrongQuestionCount;

    // 试卷提交时间
    @Tag(8)
    private Date submissionDate;

    // 考试用时
    @Tag(9)
    private int useTime;

    // 通过率
    @Tag(10)
    private double passExamProbability;

    // 测评信息
    @Tag(11)
    private List<ExamReviewSummaryView> examReviewSummaryViews;

    public boolean validate()
    {
        return userId != 0 && questions != null && questions.size() != 0;
    }

    public int getUserId()
    {

        return userId;
    }

    public void setUserId(int userId)
    {

        this.userId = userId;
    }

    public long getStudentExamId()
    {

        return studentExamId;
    }

    public void setStudentExamId(long studentExamId)
    {

        this.studentExamId = studentExamId;
    }

    public int getBookVersionId()
    {

        return bookVersionId;
    }

    public void setBookVersionId(int bookVersionId)
    {

        this.bookVersionId = bookVersionId;
    }

    public List<StudentQuestion> getQuestions()
    {

        return questions;
    }

    public void setQuestions(List<StudentQuestion> questions)
    {

        this.questions = questions;
    }

    public double getScore()
    {

        return score;
    }

    public void setScore(double score)
    {

        this.score = score;
    }

    public int getCorrectQuestionCount()
    {

        return correctQuestionCount;
    }

    public void setCorrectQuestionCount(int correctQuestionCount)
    {

        this.correctQuestionCount = correctQuestionCount;
    }

    public int getWrongQuestionCount()
    {

        return wrongQuestionCount;
    }

    public void setWrongQuestionCount(int wrongQuestionCount)
    {

        this.wrongQuestionCount = wrongQuestionCount;
    }

    public Date getSubmissionDate()
    {

        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate)
    {

        this.submissionDate = submissionDate;
    }

    public double getPassExamProbability()
    {
        return passExamProbability;
    }

    public void setPassExamProbability(double passExamProbability)
    {
        this.passExamProbability = passExamProbability;
    }

    public List<ExamReviewSummaryView> getExamReviewSummaryViews()
    {

        return examReviewSummaryViews;
    }

    public void setExamReviewSummaryViews(List<ExamReviewSummaryView> examReviewSummaryViews)
    {

        this.examReviewSummaryViews = examReviewSummaryViews;
    }

    public int getUseTime()
    {

        return useTime;
    }

    public void setUseTime(int useTime)
    {

        this.useTime = useTime;
    }

    public static String get_key()
    {

        return _key;
    }

    public static void set_key(String _key)
    {

        StudentExamResult._key = _key;
    }

    public static String _key = "StudentExamResult_%s";

    @Override
    public String key()
    {
        return String.format(keyFormat(), studentExamId);
    }

    @Override
    public String keyFormat()
    {
        return _key;
    }

    @Override
    public CouchBaseSectionType couchbaseSection()
    {
        return CouchBaseSectionType.EXAMRESULT;
    }

}
