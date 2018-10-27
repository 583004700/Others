package com.ry.xk.response.bo;

import java.util.List;

/**
 * 获取模拟测试基本信息输出实体类 <描述类的作用>
 * 
 * @ClassName: ExamModule
 * @author DELL
 * @date 2018年5月22日
 */
public class ExamModule
{

    /**
     * 测试用时
     */
    private int examTimed;

    /**
     * 测试时间,分钟
     */
    private int examTime;

    /**
     * 题目总数
     */
    private int questionCount;

    /**
     * 已作答数
     */
    private int doneQuestionCount;

    /**
     * 当前题目ID
     */
    private int lastQuestionId;

    /**
     * 答题卡
     */
    private List<AnswerSheet> answerSheets;

    public int getExamTimed() {
        return examTimed;
    }

    public void setExamTimed(int examTimed) {
        this.examTimed = examTimed;
    }

    public int getExamTime()
    {

        return examTime;
    }

    public void setExamTime(int examTime)
    {

        this.examTime = examTime;
    }

    public int getQuestionCount()
    {

        return questionCount;
    }

    public void setQuestionCount(int questionCount)
    {

        this.questionCount = questionCount;
    }

    public int getDoneQuestionCount()
    {

        return doneQuestionCount;
    }

    public void setDoneQuestionCount(int doneQuestionCount)
    {

        this.doneQuestionCount = doneQuestionCount;
    }

    public int getLastQuestionId()
    {

        return lastQuestionId;
    }

    public void setLastQuestionId(int lastQuestionId)
    {

        this.lastQuestionId = lastQuestionId;
    }

    public List<AnswerSheet> getAnswerSheets()
    {

        return answerSheets;
    }

    public void setAnswerSheets(List<AnswerSheet> answerSheets)
    {

        this.answerSheets = answerSheets;
    }

}
