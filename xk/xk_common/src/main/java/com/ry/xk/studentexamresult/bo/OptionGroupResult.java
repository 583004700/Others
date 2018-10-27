package com.ry.xk.studentexamresult.bo;

import java.util.Date;

import com.ry.xk.common.GradingResultTypeEnum;
import com.ry.xk.common.GradingTypeEnum;
import com.ry.xk.common.QuestionDoingStatusEnum;

import io.protostuff.Tag;

/**
 * 判卷结果保存字段
 * 
 * @ClassName: OptionGroupResult
 * @author 幸仁强
 * @date 2018年5月30日
 */

public class OptionGroupResult
{
    // 对应的小题ID
    @Tag(1)
    private int questionOptionGroupId;

    // 判卷结果 0=未判卷，1=正确，2=半对，3=错误
    @Tag(2)
    private GradingResultTypeEnum gradingResult;

    // 判卷时间
    @Tag(3)
    private Date createDateTime;

    // 小题中，多空的位置（第一个空、第二个空、第三个空等），从0开始计算
    @Tag(4)
    private int orderId;

    // 小题中，用户答案的Index
    @Tag(5)
    private int studentAnswerIndex;

    // 判卷类型 0-未知，1-系统判卷，2-人工判卷
    @Tag(6)
    private GradingTypeEnum gradingType;

    // 做题状态 1-未做，2-已做，3-未交
    @Tag(7)
    private QuestionDoingStatusEnum questionDoingStatus;

    // 教师是否已批改
    @Tag(8)
    private boolean isGraded;

    // 判卷 分数
    @Tag(9)
    private double score;

    public int getQuestionOptionGroupId()
    {

        return questionOptionGroupId;
    }

    public void setQuestionOptionGroupId(int questionOptionGroupId)
    {

        this.questionOptionGroupId = questionOptionGroupId;
    }

    public Date getCreateDateTime()
    {

        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime)
    {

        this.createDateTime = createDateTime;
    }

    public int getOrderId()
    {

        return orderId;
    }

    public void setOrderId(int orderId)
    {

        this.orderId = orderId;
    }

    public int getStudentAnswerIndex()
    {

        return studentAnswerIndex;
    }

    public void setStudentAnswerIndex(int studentAnswerIndex)
    {

        this.studentAnswerIndex = studentAnswerIndex;
    }

    public GradingTypeEnum getGradingType()
    {

        return gradingType;
    }

    public void setGradingType(GradingTypeEnum gradingType)
    {

        this.gradingType = gradingType;
    }

    public QuestionDoingStatusEnum getQuestionDoingStatus()
    {

        return questionDoingStatus;
    }

    public GradingResultTypeEnum getGradingResult()
    {

        return gradingResult;
    }

    public void setQuestionDoingStatus(QuestionDoingStatusEnum questionDoingStatus)
    {

        this.questionDoingStatus = questionDoingStatus;
    }

    public void setGradingResult(GradingResultTypeEnum gradingResult)
    {

        this.gradingResult = gradingResult;
    }

    public boolean isGraded()
    {

        return isGraded;
    }

    public void setGraded(boolean isGraded)
    {

        this.isGraded = isGraded;
    }

    public double getScore()
    {

        return score;
    }

    public void setScore(double score)
    {

        this.score = score;
    }

    /**
     * 是否判为错误
     * 
     * @Title: IsWrong
     * @author 幸仁强
     * @return
     */
    public boolean isWrong()
    {
        return gradingResult == GradingResultTypeEnum.Wrong || gradingResult == GradingResultTypeEnum.PartiallyCorrect;
    }

    public OptionGroupResult()
    {}

    /**
     * 创建对象，创建时间为默认时间 创建一个新的实例 OptionGroupResult.
     * 
     * @param questionOptionGroupId
     * @param gradingResult
     * @param orderId
     * @param studentAnswerIndex
     * @param gradingType
     * @param questionDoingStatus
     * @param isGraded
     * @param score
     */
    public OptionGroupResult(int questionOptionGroupId, GradingResultTypeEnum gradingResult, int orderId, int studentAnswerIndex, GradingTypeEnum gradingType,
                             QuestionDoingStatusEnum questionDoingStatus, boolean isGraded, double score)
    {
        this.createDateTime = new Date();
        this.gradingResult = gradingResult;
        this.questionOptionGroupId = questionOptionGroupId;
        this.orderId = orderId;
        this.studentAnswerIndex = studentAnswerIndex;
        this.gradingType = gradingType;
        this.questionDoingStatus = questionDoingStatus;
        this.isGraded = isGraded;
        this.score = score;
    }
}
