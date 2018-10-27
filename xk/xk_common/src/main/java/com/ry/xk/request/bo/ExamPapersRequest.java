package com.ry.xk.request.bo;


import com.ry.xk.common.bo.RequestBase;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;


/**
 * 获取学科模拟试卷列表输入实体类 <描述类的作用>
 * 
 * @ClassName: ExamPapersRequest
 * @author DELL
 * @date 2018年5月22日
 */
public class ExamPapersRequest extends RequestBase
{
    /**
     * 学科ID
     */
    @NotBlank(message = "学科不为空")
    private String courseId;

    /**
     * 购买状态
     */
    @NotNull(message = "购买状态不为空")
    private int status;

    /**
     * 每页加载数量
     */
    @NotNull(message = "每页加载数量不为空")
    private int pageSize;

    /**
     * 下一页索引
     */
    @NotNull(message = "下一页索引不为空")
    private int pageIndex;

    public String getCourseId()
    {
        return courseId;
    }

    public void setCourseId(String courseId)
    {
        this.courseId = courseId;
    }

    public int getStatus()
    {

        return status;
    }

    public void setStatus(int status)
    {

        this.status = status;
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
