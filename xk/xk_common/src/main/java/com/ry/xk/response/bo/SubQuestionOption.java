package com.ry.xk.response.bo;

/**
 * 小题选项 <描述类的作用>
 * 
 * @ClassName: subQuestionOption
 * @author DELL
 * @date 2018年5月23日
 */
public class SubQuestionOption
{
    /**
     * 小题选项
     */
    private String questionOptionId;

    /**
     * 选项描述
     */
    private String questionOptionText;

    public String getQuestionOptionId()
    {
        return questionOptionId;
    }

    public void setQuestionOptionId(String questionOptionId)
    {
        this.questionOptionId = questionOptionId;
    }

    public String getQuestionOptionText()
    {
        return questionOptionText;
    }

    public void setQuestionOptionText(String questionOptionText)
    {
        this.questionOptionText = questionOptionText;
    }

    public SubQuestionOption()
    {}

    public SubQuestionOption(String questionOptionId, String questionOptionText)
    {
        this.questionOptionId = questionOptionId;
        this.questionOptionText = questionOptionText;
    }
}
