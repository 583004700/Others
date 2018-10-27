package com.ry.xk.request.bo;

import org.hibernate.validator.constraints.NotBlank;

import com.ry.xk.common.bo.RequestBase;

/**
 * <描述类的作用>
 * 
 * @ClassName: CreateFreeExamPaperRequest
 * @author 幸仁强
 * @date 2018年5月23日
 */

public class CreateFreeExamPaperRequest extends RequestBase
{
    @NotBlank(message = "试卷ID不为空")
    private String examPaperId;

    public String getExamPaperId()
    {

        return examPaperId;
    }

    public void setExamPaperId(String examPaperId)
    {

        this.examPaperId = examPaperId;
    }

}
