package com.ry.xk.springbootframe.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = {"classpath:config/common.properties", "file:${spring.profiles.path}/common.properties"}, ignoreResourceNotFound = true)
public class CommonConfig
{
    public static String tikuServicewsdl;

    public static String studentExamServicewsdl;

    public static String omcOrderWrapperServicewsdl;

    public static String wxPayService;

    public static String WeChatAccessService;

    public static long expire;

    public static String base64Security;

    public static String getTikuServicewsdl()
    {

        return tikuServicewsdl;
    }

    @Value("${wcfurl.tikuServicewsdl}")
    public void setTikuServicewsdl(String tikuServicewsdl)
    {

        CommonConfig.tikuServicewsdl = tikuServicewsdl;
    }

    public static String getStudentExamServicewsdl()
    {

        return studentExamServicewsdl;
    }

    @Value("${wcfurl.studentExamServicewsdl}")
    public void setStudentExamServicewsdl(String studentExamServicewsdl)
    {

        CommonConfig.studentExamServicewsdl = studentExamServicewsdl;
    }

    public static String getOmcOrderWrapperServicewsdl()
    {

        return omcOrderWrapperServicewsdl;
    }

    @Value("${wcfurl.omcOrderWrapperServicewsdl}")
    public void setOmcOrderWrapperServicewsdl(String omcOrderWrapperServicewsdl)
    {

        CommonConfig.omcOrderWrapperServicewsdl = omcOrderWrapperServicewsdl;
    }

    public static String getWxPayService()
    {

        return wxPayService;
    }

    @Value("${wcfurl.wxPayService}")
    public void setWxPayService(String wxPayService)
    {

        CommonConfig.wxPayService = wxPayService;
    }

    public static String getWeChatAccessService()
    {

        return WeChatAccessService;
    }

    @Value("${wcfurl.weChatAccessService}")
    public void setWeChatAccessService(String weChatAccessService)
    {

        WeChatAccessService = weChatAccessService;
    }

    public static long getExpire()
    {

        return expire;
    }

    @Value("${jwtToken.expire}")
    public void setExpire(long expire)
    {

        CommonConfig.expire = expire;
    }

    public static String getBase64Security()
    {

        return base64Security;
    }

    @Value("${jwtToken.base64Security}")
    public void setBase64Security(String base64Security)
    {

        CommonConfig.base64Security = base64Security;
    }

}
