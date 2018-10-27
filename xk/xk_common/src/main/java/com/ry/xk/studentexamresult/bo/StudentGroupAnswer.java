package com.ry.xk.studentexamresult.bo;

import java.io.Serializable;

import io.protostuff.Tag;

/**
 * 用于保存学生做答的小题答案
 * 
 * @ClassName: StudentGroupAnswer
 * @author 幸仁强
 * @date 2018年5月30日
 */

public class StudentGroupAnswer implements Serializable
{
    private static final long serialVersionUID = 6876105219783477573L;

    // ID（小题顺序ID）
    @Tag(1)
    private int id;

    // 答案（一般题目答案都放这个字段，辨析改错等特殊情况存两条记录。尽量与题目中的答案表保存一致，后期比较好处理）
    @Tag(2)
    private String answer;

    // （同一小题多答案顺序）
    @Tag(3)
    private int orderId;

    // 小题做题方式 0。默认，1. 整题答题，2. 单空作答;
    @Tag(4)
    private int fillBlankTypeId;

    // 小题ID
    @Tag(5)
    private int questionOptionGroupId;

    // 短文改错操作类型（插入=1、修改=2、删除=0默认1）
    @Tag(6)
    private int operateType;

    // 短文改错选中的单词
    @Tag(7)
    private String wordChoose;

    // 被选中单词首字母所在存文本中的位置（第几次出现，从1开始默认1）
    @Tag(8)
    private int wordIndex;

    public int getId()
    {

        return id;
    }

    public void setId(int id)
    {

        this.id = id;
    }

    public String getAnswer()
    {

        return answer;
    }

    public void setAnswer(String answer)
    {

        this.answer = answer;
    }

    public int getOrderId()
    {

        return orderId;
    }

    public void setOrderId(int orderId)
    {

        this.orderId = orderId;
    }

    public int getFillBlankTypeId()
    {

        return fillBlankTypeId;
    }

    public void setFillBlankTypeId(int fillBlankTypeId)
    {

        this.fillBlankTypeId = fillBlankTypeId;
    }

    public int getQuestionOptionGroupId()
    {

        return questionOptionGroupId;
    }

    public void setQuestionOptionGroupId(int questionOptionGroupId)
    {

        this.questionOptionGroupId = questionOptionGroupId;
    }

    public int getOperateType()
    {

        return operateType;
    }

    public void setOperateType(int operateType)
    {

        this.operateType = operateType;
    }

    public String getWordChoose()
    {

        return wordChoose;
    }

    public void setWordChoose(String wordChoose)
    {

        this.wordChoose = wordChoose;
    }

    public int getWordIndex()
    {

        return wordIndex;
    }

    public void setWordIndex(int wordIndex)
    {

        this.wordIndex = wordIndex;
    }

    public StudentGroupAnswer()
    {}

    /**
     * 获取学生做答的小题答案 创建一个新的实例 StudentGroupAnswer.
     * 
     * @param id
     *            小题顺序id
     * @param answer
     *            答案
     * @param orderId
     *            同一小题多答案顺序
     * @param questionOptionGroupId
     *            小题ID
     * @param fillBlankTypeId
     *            小题作答类型。整体还是单空， 0.默认，1. 整题答题，2. 单空作答;
     */
    public StudentGroupAnswer(int id, String answer, int orderId, int questionOptionGroupId, int fillBlankTypeId)
    {
        this.id = id;
        this.answer = answer;
        this.orderId = orderId;
        this.questionOptionGroupId = questionOptionGroupId;
        this.fillBlankTypeId = fillBlankTypeId;
    }

    /**
     * 获取学生做答的小题答案(短文改错) 创建一个新的实例 StudentGroupAnswer.
     * 
     * @param id
     *            小题顺序id
     * @param answer
     *            答案
     * @param orderId
     *            同一小题多答案顺序
     * @param questionOptionGroupId
     *            小题ID
     * @param fillBlankTypeId
     *            小题作答类型。整体还是单空， 0.默认，1. 整题答题，2. 单空作答;
     * @param operateType
     *            短文改错操作类型（插入=1、修改=2、删除=0）
     * @param wordChoose
     *            短文改错选中的单词
     * @param wordIndex
     *            被选中单词首字母所在存文本中的位置（第几次出现，从1开始）
     */
    public StudentGroupAnswer(int id, String answer, int orderId, int questionOptionGroupId, int fillBlankTypeId, int operateType, String wordChoose, int wordIndex)
    {
        this.id = id;
        this.answer = answer;
        this.orderId = orderId;
        this.questionOptionGroupId = questionOptionGroupId;
        this.fillBlankTypeId = fillBlankTypeId;
        this.operateType = operateType;
        this.wordChoose = wordChoose;
        this.wordIndex = wordIndex;
    }
}
