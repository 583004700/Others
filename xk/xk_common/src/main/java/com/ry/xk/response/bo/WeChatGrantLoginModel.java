package com.ry.xk.response.bo;

/**
 * 获取JWTtoken后的返回对象
 * 
 * @ClassName: WeChatGrantLoginModel
 * @author 幸仁强
 * @date 2018年6月12日
 */
public class WeChatGrantLoginModel
{

    private String token;

    public String getToken()
    {

        return token;
    }

    public void setToken(String token)
    {

        this.token = token;
    }

    public WeChatGrantLoginModel()
    {}

    public WeChatGrantLoginModel(String token)
    {
        this.token = token;
    }

}
