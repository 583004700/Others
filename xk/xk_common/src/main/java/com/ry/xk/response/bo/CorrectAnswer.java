package com.ry.xk.response.bo;

/**
 * 正确答案 <描述类的作用>
 * 
 * @ClassName: CorrectAnswer
 * @author DELL
 * @date 2018年5月23日
 */
public class CorrectAnswer
{
    /**
     * 答案
     */
    private String answer = "";

    /**
     * 答案序号
     */
    private String answerIndex = "";

    public String getAnswer()
    {

        return answer;
    }

    public void setAnswer(String answer)
    {

        this.answer = answer;
    }

    public String getAnswerIndex()
    {

        return answerIndex;
    }

    public void setAnswerIndex(String answerIndex)
    {

        this.answerIndex = answerIndex;
    }

}
