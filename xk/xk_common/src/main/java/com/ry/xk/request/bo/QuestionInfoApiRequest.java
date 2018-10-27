package com.ry.xk.request.bo;

import org.hibernate.validator.constraints.NotBlank;

import com.ry.xk.common.bo.RequestBase;

import javax.validation.constraints.NotNull;

/**
 * 获取题目信息输入实体类
 *<描述类的作用>
 * @ClassName: QuestionInfoApiRequest
 * @author DELL
 * @date 2018年5月23日
 */
public class QuestionInfoApiRequest extends RequestBase
{
    /**
     * 模拟测试ID
     */
    @NotBlank(message="steId不能为空")
    private String steId;
    /**
     * 题目ID
     */
    @NotNull(message="questionId不能为空")
    private int questionId;
    
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

   
}

	