package com.ry.xk.response.bo;

import java.util.List;

public class UserAnswer
{
    // 小题ID
    private int questionOptionGroupId;

    private List<String> answer;

    public int getQuestionOptionGroupId()
    {

        return questionOptionGroupId;
    }

    public void setQuestionOptionGroupId(int questionOptionGroupId)
    {

        this.questionOptionGroupId = questionOptionGroupId;
    }

    public List<String> getAnswer()
    {

        return answer;
    }

    public void setAnswer(List<String> answer)
    {

        this.answer = answer;
    }

    public UserAnswer()
    {}

    public UserAnswer(int questionOptionGroupId, List<String> answer)
    {
        this.questionOptionGroupId = questionOptionGroupId;
        this.answer = answer;
    }
}
