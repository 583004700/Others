package com.ry.xk.studentexamresult.bo;

import java.util.Date;

import com.ry.xk.springbootframe.couchbase.CouchBaseSectionType;
import com.ry.xk.springbootframe.couchbase.ICouchBaseStoredObject;

import io.protostuff.Tag;

/**
 * StudentExam实体类（学生测试表）
 * 
 * @ClassName: StudentExam
 * @author 幸仁强
 * @date 2018年6月1日
 */

public class StudentExam implements ICouchBaseStoredObject
{
    // 学生测试ID，自增主键
    @Tag(1)
    private long studentExamId;

    // 试卷ID
    @Tag(2)
    private int examPaperId;

    // 学生ID
    @Tag(3)
    private int userId;

    // 教材版本ID
    @Tag(4)
    private int bookVersionId;

    // 测验ID
    @Tag(5)
    private int examSetId;

    // 作业状态（2已交，1未交）
    @Tag(6)
    private int examStatusId;

    // 试卷总分
    @Tag(7)
    private double totalScore;

    // 考试来源，默认为1
    @Tag(8)
    private int examSourceTypeId;

    // 学科ID
    @Tag(9)
    private int courseId;

    // 设备来源 1,PC;2, Android手机;3, 苹果客户端 Ahd;4, 安卓平板;5, 移动web端;6, Ios平板;7, Motk.API;默认为0
    @Tag(10)
    private int fromTypeId;

    // 考试结束时间
    @Tag(11)
    private Date examEndTime;

    // 题目总数
    @Tag(12)
    private int questionCount;

    // 1有效，0失效
    @Tag(13)
    private int statusFlag;

    // 创建时间
    @Tag(14)
    private Date createDateTime;

    public long getStudentExamId()
    {

        return studentExamId;
    }

    public void setStudentExamId(long studentExamId)
    {

        this.studentExamId = studentExamId;
    }

    public int getExamPaperId()
    {

        return examPaperId;
    }

    public void setExamPaperId(int examPaperId)
    {

        this.examPaperId = examPaperId;
    }

    public int getUserId()
    {

        return userId;
    }

    public void setUserId(int userId)
    {

        this.userId = userId;
    }

    public int getBookVersionId()
    {

        return bookVersionId;
    }

    public void setBookVersionId(int bookVersionId)
    {

        this.bookVersionId = bookVersionId;
    }

    public int getExamSetId()
    {

        return examSetId;
    }

    public void setExamSetId(int examSetId)
    {

        this.examSetId = examSetId;
    }

    public int getExamStatusId()
    {

        return examStatusId;
    }

    public void setExamStatusId(int examStatusId)
    {

        this.examStatusId = examStatusId;
    }

    public double getTotalScore()
    {

        return totalScore;
    }

    public void setTotalScore(double totalScore)
    {

        this.totalScore = totalScore;
    }

    public int getExamSourceTypeId()
    {

        return examSourceTypeId;
    }

    public void setExamSourceTypeId(int examSourceTypeId)
    {

        this.examSourceTypeId = examSourceTypeId;
    }

    public int getCourseId()
    {

        return courseId;
    }

    public void setCourseId(int courseId)
    {

        this.courseId = courseId;
    }

    public int getFromTypeId()
    {

        return fromTypeId;
    }

    public void setFromTypeId(int fromTypeId)
    {

        this.fromTypeId = fromTypeId;
    }

    public Date getExamEndTime()
    {

        return examEndTime;
    }

    public void setExamEndTime(Date examEndTime)
    {

        this.examEndTime = examEndTime;
    }

    public int getQuestionCount()
    {

        return questionCount;
    }

    public void setQuestionCount(int questionCount)
    {

        this.questionCount = questionCount;
    }

    public int getStatusFlag()
    {

        return statusFlag;
    }

    public void setStatusFlag(int statusFlag)
    {

        this.statusFlag = statusFlag;
    }

    public Date getCreateDateTime()
    {

        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime)
    {

        this.createDateTime = createDateTime;
    }

    private static String _key = "StudentExam_%s";

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

    public StudentExam()
    {}

    public StudentExam(int examPaperId, int userId, int examSetId, int examStatusId, double totalScore, int courseId, int questionCount, int statusFlag, Date createDateTime)
    {
        this.examPaperId = examPaperId;
        this.userId = userId;
        this.examSetId = examSetId;
        this.examStatusId = examStatusId;
        this.totalScore = totalScore;
        this.courseId = courseId;
        this.questionCount = questionCount;
        this.statusFlag = statusFlag;
        this.createDateTime = createDateTime;
    }

}
