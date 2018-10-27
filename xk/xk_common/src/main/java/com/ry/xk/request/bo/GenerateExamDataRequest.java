package com.ry.xk.request.bo;

import org.hibernate.validator.constraints.NotBlank;

import com.ry.xk.common.bo.RequestBase;

/**
 * 试卷详情输入参数实体类 <描述类的作用>
 * 
 * @ClassName: PaperDetailApiRequest
 * @author DELL
 * @date 2018年5月22日
 */
public class GenerateExamDataRequest extends RequestBase
{
    /**
     * 试卷ID
     */
    @NotBlank(message = "examPaperId不允许为空")
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
