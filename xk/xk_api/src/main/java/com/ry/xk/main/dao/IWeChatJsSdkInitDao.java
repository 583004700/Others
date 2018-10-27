package com.ry.xk.main.dao;

import org.springframework.stereotype.Component;

import com.ry.xk.studentexamresult.bo.ThirdPartyAccessToken;
import com.ry.xk.studentexamresult.bo.ThirdPartyTicket;

/**
 * 用户数据层接口
 * 
 * @author 幸仁强
 */
@Component
public interface IWeChatJsSdkInitDao
{

    /**
     * 获取AccessToken对象
     */
    public ThirdPartyAccessToken getAccessToken(int partnerId)
        throws Exception;

    /**
     * 更新AccessToken对象
     */
    public boolean updateAccessToken(ThirdPartyAccessToken thirdPartyAccessToken)
        throws Exception;

    /**
     * 获取Ticket对象
     */
    public ThirdPartyTicket getTicket(int partnerId)
        throws Exception;

    /**
     * 更新Ticket对象
     */
    public boolean updateTicket(ThirdPartyTicket thirdPartyTicket)
        throws Exception;
}