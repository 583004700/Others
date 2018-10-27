package com.ry.xk.studentexamresult.bo;

import java.util.Date;
import java.util.List;

import io.protostuff.Tag;

/**
 * 错题
 */
public class WrongQuestion
{
    /**
     * 题目ID
     */
    @Tag(1)
    private int questionId;

    /**
     * 创建时间
     */
    @Tag(2)
    private Date createTime;

    /**
     * 学生提交的各小题答案
     */
    @Tag(3)
    private List<StudentGroupAnswer> studentGroupAnswers;

    /**
     * 临时判卷结果
     */
    @Tag(4)
    private List<OptionGroupResult> gradingResult;

    /**
     * 是否有效 1有效 0无效
     */
    @Tag(5)
    private int statusFlag;

    public int getQuestionId()
    {
        return questionId;
    }

    public void setQuestionId(int questionId)
    {
        this.questionId = questionId;
    }

    public Date getCreateTime()
    {

        return createTime;
    }

    public void setCreateTime(Date createTime)
    {

        this.createTime = createTime;
    }

    public List<StudentGroupAnswer> getStudentGroupAnswers()
    {

        return studentGroupAnswers;
    }

    public void setStudentGroupAnswers(List<StudentGroupAnswer> studentGroupAnswers)
    {

        this.studentGroupAnswers = studentGroupAnswers;
    }

    public List<OptionGroupResult> getGradingResult()
    {

        return gradingResult;
    }

    public void setGradingResult(List<OptionGroupResult> gradingResult)
    {

        this.gradingResult = gradingResult;
    }

    public int getStatusFlag()
    {
        return statusFlag;
    }

    public void setStatusFlag(int statusFlag)
    {
        this.statusFlag = statusFlag;
    }

    public WrongQuestion()
    {}

    public WrongQuestion(int questionId, List<StudentGroupAnswer> studentGroupAnswers, List<OptionGroupResult> gradingResult, int statusFlag)
    {
        this.questionId = questionId;
        this.studentGroupAnswers = studentGroupAnswers;
        this.createTime = new Date();
        this.gradingResult = gradingResult;
        this.statusFlag = statusFlag;
    }
}
