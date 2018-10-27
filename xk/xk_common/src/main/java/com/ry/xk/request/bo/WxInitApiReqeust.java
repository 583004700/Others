package com.ry.xk.request.bo;

import org.hibernate.validator.constraints.NotBlank;

import com.ry.xk.common.bo.RequestBase;

/**
 * 获取微信网页JSSDK 初始化参数输入实体类
 *<描述类的作用>
 * @ClassName: WxInitApiReqeust
 * @author DELL
 * @date 2018年5月22日
 */
public class WxInitApiReqeust extends RequestBase
{
    /**
     * 当前页url
     */
    @NotBlank(message = "url不允许为空")
    private String url;
   
    public String getUrl()
    {
    
        return url;
    }
    public void setUrl(String url)
    {
    
        this.url = url;
    }
    
}
