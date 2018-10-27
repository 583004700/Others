package com.ry.xk.request.bo;


import com.ry.xk.common.bo.RequestBase;

import javax.validation.constraints.NotNull;


/**
 * <描述类的作用>
 * 
 * @ClassName: CoursesRequest
 * @author 幸仁强
 * @date 2018年5月23日
 */

public class CoursesRequest extends RequestBase
{
    // 学段
    @NotNull(message = "学段不为空")
    private int courseTypeId;

    public int getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(int courseTypeId) {
        this.courseTypeId = courseTypeId;
    }
}
