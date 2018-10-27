package com.ry.xk.studentexamresult.bo;

import java.util.Date;
import java.util.List;

import com.ry.xk.springbootframe.couchbase.CouchBaseSectionType;
import com.ry.xk.springbootframe.couchbase.ICouchBaseStoredObject;

import io.protostuff.Tag;

/**
 * 学生做测试时候的数据对象
 * 
 * @ClassName: StudentExamInProgressInfo
 * @author 幸仁强
 * @date 2018年5月30日
 */
public class StudentExamInProgressInfo implements ICouchBaseStoredObject
{
    // 测试ID
    @Tag(1)
    private long studentExamId;

    // 题集ID
    @Tag(2)
    private int examSetId;

    // 本次考试的题目
    @Tag(3)
    private List<StudentExamProgressQuestion> examDoingQuestions;

    // 教材版本id
    @Tag(4)
    private int bookVersionId;

    // 课程id
    @Tag(5)
    private int courseMappingId;

    // 用户id
    @Tag(6)
    private int userId;

    // 上一次保存退出时的题目ID
    @Tag(7)
    private int lastQuestionId;

    // 最近一次保存的时间
    @Tag(8)
    private Date lastSaveTime;

    // 学科ID
    @Tag(9)
    private int courseId;

    public boolean Validate()
    {
        return userId != 0 && examDoingQuestions != null && examDoingQuestions.size() != 0;
    }

    public long getStudentExamId()
    {

        return studentExamId;
    }

    public void setStudentExamId(long studentExamId)
    {

        this.studentExamId = studentExamId;
    }

    public int getExamSetId()
    {

        return examSetId;
    }

    public void setExamSetId(int examSetId)
    {

        this.examSetId = examSetId;
    }

    public List<StudentExamProgressQuestion> getExamDoingQuestions()
    {

        return examDoingQuestions;
    }

    public void setExamDoingQuestions(List<StudentExamProgressQuestion> examDoingQuestions)
    {

        this.examDoingQuestions = examDoingQuestions;
    }

    public int getBookVersionId()
    {

        return bookVersionId;
    }

    public void setBookVersionId(int bookVersionId)
    {

        this.bookVersionId = bookVersionId;
    }

    public int getCourseMappingId()
    {

        return courseMappingId;
    }

    public void setCourseMappingId(int courseMappingId)
    {

        this.courseMappingId = courseMappingId;
    }

    public int getUserId()
    {

        return userId;
    }

    public void setUserId(int userId)
    {

        this.userId = userId;
    }

    public int getLastQuestionId()
    {

        return lastQuestionId;
    }

    public void setLastQuestionId(int lastQuestionId)
    {

        this.lastQuestionId = lastQuestionId;
    }

    public Date getLastSaveTime()
    {

        return lastSaveTime;
    }

    public void setLastSaveTime(Date lastSaveTime)
    {

        this.lastSaveTime = lastSaveTime;
    }

    public int getCourseId()
    {

        return courseId;
    }

    public void setCourseId(int courseId)
    {

        this.courseId = courseId;
    }

    public static String _key = "StudentExamDoingInfo_%s";

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

    public StudentExamInProgressInfo()
    {}

    public StudentExamInProgressInfo(long studentExamId, int examSetId, List<StudentExamProgressQuestion> examDoingQuestions, int bookVersionId, int courseMappingId, int userId, int lastQuestionId,
                                     Date lastSaveTime, int courseId)
    {
        this.studentExamId = studentExamId;
        this.examSetId = examSetId;
        this.examDoingQuestions = examDoingQuestions;
        this.userId = userId;
        this.lastQuestionId = lastQuestionId;
        this.lastSaveTime = lastSaveTime;
        this.courseId = courseId;
    }

}
