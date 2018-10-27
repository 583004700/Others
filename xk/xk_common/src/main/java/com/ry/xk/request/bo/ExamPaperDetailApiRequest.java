package com.ry.xk.request.bo;


import com.ry.xk.common.bo.RequestBase;
import org.hibernate.validator.constraints.NotBlank;


/**
 * 试卷详情输入参数实体类 <描述类的作用>
 * 
 * @ClassName: PaperDetailApiRequest
 * @author DELL
 * @date 2018年5月22日
 */
public class ExamPaperDetailApiRequest extends RequestBase
{
    /**
     * 试卷ID
     */
    @NotBlank(message = "examPaperId不能为空")
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
