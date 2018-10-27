package com.ry.xk.response.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取试卷解析小题答案
 *<描述类的作用>
 * @ClassName: SubQuestionAnswer
 * @author DELL
 * @date 2018年5月23日
 */
public class SubQuestionAnswer
{
    /**
     * 正确答案
     */
    private List<CorrectAnswer> correctAnswers = new ArrayList<CorrectAnswer>();
    /**
     * 大题是否做对
     */
    private boolean questionIsCorrect;
    /**
     * 用户答案
     */
    private List<SubUserAnswer> userAnswers = new ArrayList<SubUserAnswer>();
    public List<CorrectAnswer> getCorrectAnswers()
    {
    
        return correctAnswers;
    }
    public void setCorrectAnswers(List<CorrectAnswer> correctAnswers)
    {
    
        this.correctAnswers = correctAnswers;
    }
    public boolean isQuestionIsCorrect()
    {
    
        return questionIsCorrect;
    }
    public void setQuestionIsCorrect(boolean questionIsCorrect)
    {
    
        this.questionIsCorrect = questionIsCorrect;
    }
    public List<SubUserAnswer> getUserAnswers()
    {
    
        return userAnswers;
    }
    public void setUserAnswers(List<SubUserAnswer> userAnswers)
    {
    
        this.userAnswers = userAnswers;
    }
}

	