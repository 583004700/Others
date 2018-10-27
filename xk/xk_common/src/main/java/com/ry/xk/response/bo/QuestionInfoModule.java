package com.ry.xk.response.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取题目信息输出实体类 <描述类的作用>
 * 
 * @ClassName: QuestionInfoModule
 * @author DELL
 * @date 2018年5月23日
 */
public class QuestionInfoModule
{
    /**
     * 题目ID
     */
    private int questionId;

    /**
     * 题目序号
     */
    private int orderIndex;

    /**
     * 题型ID
     */
    private int questionDisplayTypeId;

    /**
     * 题干
     */
    private String questionContent = "";

    /**
     * 小题列表
     */
    private List<QuestionGroupModel> optionGroups = new ArrayList<QuestionGroupModel>();

    /**
     * 题型信息
     */
    private QuestionCategoryModel questionCategory = new QuestionCategoryModel();

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

    public int getQuestionDisplayTypeId()
    {

        return questionDisplayTypeId;
    }

    public void setQuestionDisplayTypeId(int questionDisplayTypeId)
    {

        this.questionDisplayTypeId = questionDisplayTypeId;
    }

    public String getQuestionContent()
    {
        return questionContent;
    }

    public void setQuestionContent(String questionContent)
    {
        this.questionContent = questionContent;
    }

    public List<QuestionGroupModel> getOptionGroups()
    {

        return optionGroups;
    }

    public void setOptionGroups(List<QuestionGroupModel> optionGroups)
    {

        this.optionGroups = optionGroups;
    }

    public QuestionCategoryModel getQuestionCategory()
    {

        return questionCategory;
    }

    public void setQuestionCategory(QuestionCategoryModel questionCategory)
    {

        this.questionCategory = questionCategory;
    }

}
