package com.ry.xk.response.bo;

public class AnalysisAnswerSheets
{
    /**
     * 题目序号
     */
    private int orderIndex;

    /**
     * 题目ID
     */
    private int questionId;

    /**
     * 题目批改状态
     */
    private int questionCorrectStatus;

    public int getOrderIndex()
    {

        return orderIndex;
    }

    public void setOrderIndex(int orderIndex)
    {

        this.orderIndex = orderIndex;
    }

    public int getQuestionId()
    {

        return questionId;
    }

    public void setQuestionId(int questionId)
    {

        this.questionId = questionId;
    }

    public int getQuestionCorrectStatus()
    {
        return questionCorrectStatus;
    }

    public void setQuestionCorrectStatus(int questionCorrectStatus)
    {
        this.questionCorrectStatus = questionCorrectStatus;
    }
}
