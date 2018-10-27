package com.ry.xk.response.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取试卷解析的题目数据 <描述类的作用>
 * 
 * @ClassName: QuestionData
 * @author DELL
 * @date 2018年5月23日
 */
public class QuestionData
{
    /**
     * 题目ID
     */
    private int questionId;

    /**
     * 题目类型
     */
    private int questionDisplayTypeId;

    /**
     * 题目题干
     */
    private String questionContent = "";

    /**
     * 题目序号
     */
    private int orderIndex;

    /**
     * 解析
     */
    private String questionAnalysis = "";

    /**
     * 小题信息集合
     */
    private List<SubQuestionInfo> questionGroups = new ArrayList<SubQuestionInfo>();

    /**
     * 题型信息
     */
    private QuestionCategoryModel questionCategory = new QuestionCategoryModel();

    public String getQuestionContent()
    {

        return questionContent;
    }

    public void setQuestionContent(String questionContent)
    {

        this.questionContent = questionContent;
    }

    public int getQuestionId()
    {

        return questionId;
    }

    public void setQuestionId(int questionId)
    {

        this.questionId = questionId;
    }

    public int getQuestionDisplayTypeId()
    {

        return questionDisplayTypeId;
    }

    public void setQuestionDisplayTypeId(int questionDisplayTypeId)
    {

        this.questionDisplayTypeId = questionDisplayTypeId;
    }

    public int getOrderIndex()
    {

        return orderIndex;
    }

    public void setOrderIndex(int orderIndex)
    {

        this.orderIndex = orderIndex;
    }

    public String getQuestionAnalysis()
    {

        return questionAnalysis;
    }

    public void setQuestionAnalysis(String questionAnalysis)
    {

        this.questionAnalysis = questionAnalysis;
    }

    public List<SubQuestionInfo> getQuestionGroups()
    {

        return questionGroups;
    }

    public void setQuestionGroups(List<SubQuestionInfo> questionGroups)
    {

        this.questionGroups = questionGroups;
    }

    public QuestionCategoryModel getQuestionCategory() {
        return questionCategory;
    }

    public void setQuestionCategory(QuestionCategoryModel questionCategory) {
        this.questionCategory = questionCategory;
    }
}
