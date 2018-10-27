package com.ry.xk.response.bo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 答题卡 <描述类的作用>
 * 
 * @ClassName: AnswerCard
 * @author DELL
 * @date 2018年5月22日
 */
public class AnswerSheet
{
    /**
     * 题目ID
     */
    private int questionId;

    /**
     * 序号
     */
    private int orderIndex;

    /**
     * 是否已做
     */
    private boolean isDone;

    public AnswerSheet(){}

    public AnswerSheet(int questionId, int orderIndex, boolean isDone) {
        this.questionId = questionId;
        this.orderIndex = orderIndex;
        this.isDone = isDone;
    }

    /**
     * 带参构造方法
     * @return
     */


    public int getQuestionId()
    {

        return questionId;
    }

    public void setQuestionId(int questionId)
    {

        this.questionId = questionId;
    }

    public int getOrderIndex()
    {

        return orderIndex;
    }

    public void setOrderIndex(int orderIndex)
    {

        this.orderIndex = orderIndex;
    }
    @JsonProperty(value="isDone")
    public boolean getIsDone()
    {

        return isDone;
    }

    public void setIsDone(boolean isDone)
    {

        this.isDone = isDone;
    }

}
