package com.ry.xk.response.bo;

/**
 * 题型信息 <描述类的作用>
 * 
 * @ClassName: TiXingInfo
 * @author DELL
 * @date 2018年5月23日
 */
public class QuestionCategoryModel
{
    /**
     * 题型类型ID
     */
    private int questionCategoryId;

    /**
     * 题型类型名称
     */
    private String questionCategoryName;

    public int getQuestionCategoryId()
    {

        return questionCategoryId;
    }

    public void setQuestionCategoryId(int questionCategoryId)
    {

        this.questionCategoryId = questionCategoryId;
    }

    public String getQuestionCategoryName()
    {

        return questionCategoryName;
    }

    public void setQuestionCategoryName(String questionCategoryName)
    {

        this.questionCategoryName = questionCategoryName;
    }

}
