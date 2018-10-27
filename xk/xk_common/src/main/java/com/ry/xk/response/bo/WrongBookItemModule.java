package com.ry.xk.response.bo;

public class WrongBookItemModule
{
    /**
     * 题目ID
     */
    private int questionId;

    /**
     * 题型名称
     */
    private String questionCategoryName = "";

    /**
     * 时间
     */
    private String time = "";

    /**
     * 题干内容
     */
    private String questionContent = "";

    public int getQuestionId()
    {

        return questionId;
    }

    public void setQuestionId(int questionId)
    {

        this.questionId = questionId;
    }

    public String getQuestionCategoryName()
    {

        return questionCategoryName;
    }

    public void setQuestionCategoryName(String questionCategoryName)
    {

        this.questionCategoryName = questionCategoryName;
    }

    public String getTime()
    {

        return time;
    }

    public void setTime(String time)
    {

        this.time = time;
    }

    public String getQuestionContent()
    {

        return questionContent;
    }

    public void setQuestionContent(String questionContent)
    {

        this.questionContent = questionContent;
    }

}
