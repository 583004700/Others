package com.ry.xk.response.bo;

/**
 * <描述类的作用>
 * 
 * @ClassName: StudentAnswerModel
 * @author 幸仁强
 * @date 2018年5月24日
 */

public class StudentAnswerModel
{
    // 答案内容
    private String answer;

    // 序号
    private int orderIndex;

    /**
     * 是否回答正确 0未做，1正确，2错误
     */
    private int correctIsTypeId;

    public String getAnswer()
    {

        return answer;
    }

    public void setAnswer(String answer)
    {

        this.answer = answer;
    }

    public int getOrderIndex()
    {

        return orderIndex;
    }

    public void setOrderIndex(int orderIndex)
    {

        this.orderIndex = orderIndex;
    }

    public int getCorrectIsTypeId()
    {

        return correctIsTypeId;
    }

    public void setCorrectIsTypeId(int correctIsTypeId)
    {

        this.correctIsTypeId = correctIsTypeId;
    }

    public StudentAnswerModel()
    {

    }

    /**
     * 构建实体
     * 
     * @Title: GetInstance
     * @author 幸仁强
     * @param answer
     *            答案
     * @param orderIndex
     *            序号
     * @param correctIsTypeId
     *            是否正确枚举
     * @return
     */
    public StudentAnswerModel(String answer, int orderIndex, int correctIsTypeId)
    {
        this.answer = answer;
        this.orderIndex = orderIndex;
        this.correctIsTypeId = correctIsTypeId;
    };
}
