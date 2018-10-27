package com.ry.xk.studentexamresult.bo;

import java.util.Date;

import io.protostuff.Tag;

/**
 * 用户做题信息，（StudentExamList专用）
 */
public class StudentExamItem
{
    // 用户ID
    @Tag(1)
    private int userId;

    // 试卷ID
    @Tag(2)
    private int examPaperId;

    // 测试ID
    @Tag(3)
    private long studentExamId;

    // 创建时间
    @Tag(4)
    private Date createDateTime;

    // 结束时间
    @Tag(5)
    private Date endDateTime;

    // 是否生成测评
    @Tag(6)
    private boolean isGenerateEvaluation;

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public int getExamPaperId()
    {

        return examPaperId;
    }

    public void setExamPaperId(int examPaperId)
    {

        this.examPaperId = examPaperId;
    }

    public long getStudentExamId()
    {

        return studentExamId;
    }

    public void setStudentExamId(long studentExamId)
    {

        this.studentExamId = studentExamId;
    }

    public Date getCreateDateTime()
    {

        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime)
    {

        this.createDateTime = createDateTime;
    }

    public Date getEndDateTime()
    {

        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime)
    {

        this.endDateTime = endDateTime;
    }

    public boolean getIsGenerateEvaluation()
    {

        return isGenerateEvaluation;
    }

    public void setIsGenerateEvaluation(boolean isGenerateEvaluation)
    {

        this.isGenerateEvaluation = isGenerateEvaluation;
    }

    public StudentExamItem()
    {}

    public StudentExamItem(int userId, int examPaperId, long studentExamId, Date createDateTime, Date endDateTime, boolean isGenerateEvaluation)
    {
        this.userId = userId;
        this.examPaperId = examPaperId;
        this.studentExamId = studentExamId;
        this.createDateTime = createDateTime;
        this.endDateTime = endDateTime;
        this.isGenerateEvaluation = isGenerateEvaluation;
    }

}
