package com.ry.xk.request.bo;


import com.ry.xk.common.bo.RequestBase;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;


public class WrongBookApiRequest extends RequestBase
{
    /**
     * 学科ID
     */
    @NotBlank(message = "学科不为空")
    private String courseId;

    /**
     * 每页数
     */
    private int pageSize;

    /**
     * 页码
     */
    @NotNull(message = "页码不为空")
    private int pageIndex;

    public String getCourseId()
    {

        return courseId;
    }

    public void setCourseId(String courseId)
    {

        this.courseId = courseId;
    }

    public int getPageSize()
    {

        return pageSize;
    }

    public void setPageSize(int pageSize)
    {

        this.pageSize = pageSize;
    }

    public int getPageIndex()
    {

        return pageIndex;
    }

    public void setPageIndex(int pageIndex)
    {

        this.pageIndex = pageIndex;
    }

}
