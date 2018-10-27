package com.ry.xk.request.bo;

import com.ry.xk.common.bo.RequestBase;

/**
 * 创建订单入参
 * 
 * @ClassName: CreateOrderApiRequest
 * @author 幸仁强
 * @date 2018年6月8日
 */
public class CreateOrderApiRequest extends RequestBase
{
    private boolean isBuyAll;

    private String courseId;

    private String examPaperId;

    public boolean getIsBuyAll()
    {

        return isBuyAll;
    }

    public void setIsBuyAll(boolean isBuyAll)
    {

        this.isBuyAll = isBuyAll;
    }

    public String getCourseId()
    {

        return courseId;
    }

    public void setCourseId(String courseId)
    {

        this.courseId = courseId;
    }

    public String getExamPaperId()
    {

        return examPaperId;
    }

    public void setExamPaperId(String examPaperId)
    {

        this.examPaperId = examPaperId;
    }

}
