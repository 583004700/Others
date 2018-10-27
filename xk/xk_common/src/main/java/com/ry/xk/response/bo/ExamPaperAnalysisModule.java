package com.ry.xk.response.bo;

/**
 * 获取试卷解析公共输出实体类 <描述类的作用>
 * 
 * @ClassName: PaperTranlateModule
 * @author DELL
 * @date 2018年5月23日
 */
public class ExamPaperAnalysisModule
{
    /**
     * 下一题
     */
    private int nextQuestionId;

    /**
     * 上一题
     */
    private int previousQuestionId;

    /**
     * 题目数据
     */
    private QuestionData questionInfo = new QuestionData();

    public int getNextQuestionId()
    {
        return nextQuestionId;
    }

    public void setNextQuestionId(int nextQuestionId)
    {
        this.nextQuestionId = nextQuestionId;
    }

    public int getPreviousQuestionId()
    {
        return previousQuestionId;
    }

    public void setPreviousQuestionId(int previousQuestionId)
    {
        this.previousQuestionId = previousQuestionId;
    }

    public QuestionData getQuestionInfo()
    {
        return questionInfo;
    }

    public void setQuestionInfo(QuestionData questionInfo)
    {
        this.questionInfo = questionInfo;
    }

}
