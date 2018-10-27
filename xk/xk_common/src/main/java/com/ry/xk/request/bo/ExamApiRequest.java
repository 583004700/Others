package com.ry.xk.request.bo;


import com.ry.xk.common.bo.RequestBase;
import org.hibernate.validator.constraints.NotBlank;


/**
 * 获取模拟测试基本信息输入实体类 <描述类的作用>
 * 
 * @ClassName: ExamApiRequest
 * @author DELL
 * @date 2018年5月22日
 */
public class ExamApiRequest extends RequestBase
{
    /**
     * 测试ID
     */
    @NotBlank(message = "steId不能为空")
    private String steId;

    private int useTime;

    public String getSteId()
    {

        return steId;
    }

    public void setSteId(String steId)
    {

        this.steId = steId;
    }

    public int getUseTime()
    {

        return useTime;
    }

    public void setUseTime(int useTime)
    {

        this.useTime = useTime;
    }

}
