package com.ry.xk.request.bo;

import org.hibernate.validator.constraints.NotBlank;

import com.ry.xk.common.bo.RequestBase;

/**
 * 获取授权信息输入实体类 <描述类的作用>
 * 
 * @ClassName: AutoInfoInput
 * @author DELL
 * @date 2018年5月22日
 */
public class AuthInfoApiReqeust extends RequestBase
{
    /**
     * 微信code
     */
    @NotBlank(message = "code不允许为空")
    private String code;

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }
}
