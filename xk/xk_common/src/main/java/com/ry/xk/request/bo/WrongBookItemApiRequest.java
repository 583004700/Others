package com.ry.xk.request.bo;


import com.ry.xk.common.bo.RequestBase;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;


public class WrongBookItemApiRequest extends RequestBase
{
    /**
     * 科目ID
     */
    @NotBlank(message = "科目ID不为空")
    private String courseId;

    /**
     * 题目ID
     */
    @NotNull(message = "题目ID不为空")
    private int questionId;

    public String getCourseId()
    {

        return courseId;
    }

    public void setCourseId(String courseId)
    {

        this.courseId = courseId;
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
