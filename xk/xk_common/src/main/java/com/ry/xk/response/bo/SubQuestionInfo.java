package com.ry.xk.response.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取试卷解析小题信息 <描述类的作用>
 * 
 * @ClassName: SubQuestionInfo
 * @author DELL
 * @date 2018年5月23日
 */
public class SubQuestionInfo
{
    /**
     * 小题ID
     */
    private int questionGroupId;

    /**
     * 小题题干
     */
    private String questionGroupContent;

    /**
     * 小题类型
     */
    private int questionGroupDisplayTypeId;

    /**
     * 小题选项
     */
    private List<OptionModel> options = new ArrayList<OptionModel>();

    /**
     * 小题答案
     */
    private QuestionAnswerModel questionAnswer = new QuestionAnswerModel();

    public int getQuestionGroupId()
    {

        return questionGroupId;
    }

    public void setQuestionGroupId(int questionGroupId)
    {

        this.questionGroupId = questionGroupId;
    }

    public String getQuestionGroupContent()
    {

        return questionGroupContent;
    }

    public void setQuestionGroupContent(String questionGroupContent)
    {

        this.questionGroupContent = questionGroupContent;
    }

    public int getQuestionGroupDisplayTypeId()
    {

        return questionGroupDisplayTypeId;
    }

    public void setQuestionGroupDisplayTypeId(int questionGroupDisplayTypeId)
    {

        this.questionGroupDisplayTypeId = questionGroupDisplayTypeId;
    }

    public List<OptionModel> getOptions()
    {

        return options;
    }

    public void setOptions(List<OptionModel> options)
    {

        this.options = options;
    }

    public QuestionAnswerModel getQuestionAnswer()
    {

        return questionAnswer;
    }

    public void setQuestionAnswer(QuestionAnswerModel questionAnswer)
    {

        this.questionAnswer = questionAnswer;
    }

}
