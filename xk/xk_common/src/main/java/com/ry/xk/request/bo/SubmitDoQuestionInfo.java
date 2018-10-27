package com.ry.xk.request.bo;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

import com.ry.xk.common.bo.RequestBase;
import com.ry.xk.response.bo.UserAnswer;

import javax.validation.constraints.NotNull;

/**
 * 提交做题信息 <描述类的作用>
 * 
 * @ClassName: SubmitDoQuestionInfo
 * @author DELL
 * @date 2018年5月23日
 */
public class SubmitDoQuestionInfo extends RequestBase
{
    /**
     * 测试ID
     */
    @NotBlank(message="steId不能为空")
    private String steId;

    /**
     * 题目ID
     */
    @NotNull(message="questionId不能为空")
    private int questionId;

    /**
     * 用户答案
     */
    private List<UserAnswer> userAnswers;

    private int displayTypeId; // 题目类型

    private int currentQuestionIndex; // 当前题目序号

    private byte doingType; // 做题类型

    public String getSteId()
    {

        return steId;
    }

    public void setSteId(String steId)
    {

        this.steId = steId;
    }

    public int getQuestionId()
    {

        return questionId;
    }

    public void setQuestionId(int questionId)
    {

        this.questionId = questionId;
    }

    public List<UserAnswer> getUserAnswers()
    {

        return userAnswers;
    }

    public void setUserAnswers(List<UserAnswer> userAnswers)
    {

        this.userAnswers = userAnswers;
    }

    public int getDisplayTypeId()
    {

        return displayTypeId;
    }

    public void setDisplayTypeId(int displayTypeId)
    {

        this.displayTypeId = displayTypeId;
    }

    public int getCurrentQuestionIndex()
    {

        return currentQuestionIndex;
    }

    public void setCurrentQuestionIndex(int currentQuestionIndex)
    {

        this.currentQuestionIndex = currentQuestionIndex;
    }

    public byte getDoingType()
    {

        return doingType;
    }

    public void setDoingType(byte doingType)
    {

        this.doingType = doingType;
    }

}
