package com.ry.xk.studentexamresult.bo;

import java.util.Date;

import io.protostuff.Tag;

/**
 *
 */
public class ExamPaperQuestion
{
    // 试卷ID
    @Tag(1)
    private int examPaperId;

    // 题目ID
    @Tag(2)
    private int questionId;

    // 排序字段
    @Tag(3)
    private int orderIndex;

    // 题目分值
    @Tag(4)
    private float questionScore;

    // 绑定状态 1有效 0无效
    @Tag(5)
    private int statusFlag;

    // 创建时间
    @Tag(6)
    private Date createDateTime;

    // 更新时间
    @Tag(7)
    private Date updateDateTime;

    public int getExamPaperId()
    {

        return examPaperId;
    }

    public void setExamPaperId(int examPaperId)
    {

        this.examPaperId = examPaperId;
    }

    public int getQuestionId()
    {
        return questionId;
    }

    public void setQuestionId(int questionId)
    {
        this.questionId = questionId;
    }

    public int getOrderIndex()
    {
        return orderIndex;
    }

    public void setOrderIndex(int orderIndex)
    {
        this.orderIndex = orderIndex;
    }

    public float getQuestionScore()
    {
        return questionScore;
    }

    public void setQuestionScore(float questionScore)
    {
        this.questionScore = questionScore;
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

    public Date getUpdateDateTime()
    {
        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime)
    {
        this.updateDateTime = updateDateTime;
    }
}
