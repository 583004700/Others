package com.ry.xk.response.bo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubUserAnswer
{
    /**
     * 答案
     */
    private String answer = "";
    /**
     * 答案序号
     */
    private String answerIndex;
    /**
     * 是否回答正确
     */
    private boolean isCorrect;
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
    @JsonProperty(value="isCorrect")
    public boolean getIsCorrect()
    {
    
        return isCorrect;
    }
    public void setIsCorrect(boolean isCorrect)
    {
    
        this.isCorrect = isCorrect;
    }
    
}

	