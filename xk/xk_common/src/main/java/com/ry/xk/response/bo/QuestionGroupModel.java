package com.ry.xk.response.bo;

import java.util.List;

/**
 * 小题 <描述类的作用>
 * 
 * @ClassName: SubQuestion
 * @author DELL
 * @date 2018年5月23日
 */
public class QuestionGroupModel
{
    /**
     * 小题ID
     */
    private int questionGroupId;

    /**
     * 小题类型
     */
    private int questionGroupDisplayTypeId;

    /**
     * 小题题干
     */
    private String questionText;

    /**
     * 用户答案
     */
    private UserAnswer answer;

    /**
     * 小题选项
     */
    private List<SubQuestionOption> options;

    public int getQuestionGroupId()
    {

        return questionGroupId;
    }

    public void setQuestionGroupId(int questionGroupId)
    {

        this.questionGroupId = questionGroupId;
    }

    public int getQuestionGroupDisplayTypeId()
    {

        return questionGroupDisplayTypeId;
    }

    public void setQuestionGroupDisplayTypeId(int questionGroupDisplayTypeId)
    {

        this.questionGroupDisplayTypeId = questionGroupDisplayTypeId;
    }

    public String getQuestionText()
    {

        return questionText;
    }

    public void setQuestionText(String questionText)
    {

        this.questionText = questionText;
    }

    public UserAnswer getAnswer()
    {
    
        return answer;
    }

    public void setAnswer(UserAnswer answer)
    {
    
        this.answer = answer;
    }

    public List<SubQuestionOption> getOptions()
    {
        return options;
    }

    public void setOptions(List<SubQuestionOption> options)
    {
        this.options = options;
    }

    public QuestionGroupModel()
    {}

    public QuestionGroupModel(int questionGroupId, int questionGroupDisplayTypeId, String questionText, UserAnswer answer, List<SubQuestionOption> options)
    {
        this.questionGroupId = questionGroupId;
        this.questionGroupDisplayTypeId = questionGroupDisplayTypeId;
        this.questionText = questionText;
        this.answer = answer;
        this.options = options;
    }
}
