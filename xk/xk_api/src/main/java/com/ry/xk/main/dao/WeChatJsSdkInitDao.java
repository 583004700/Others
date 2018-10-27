package com.ry.xk.main.dao;

import org.springframework.stereotype.Component;

import com.ry.xk.common.CommonConst;
import com.ry.xk.main.service.CouchBaseFactory;
import com.ry.xk.studentexamresult.bo.ThirdPartyAccessToken;
import com.ry.xk.studentexamresult.bo.ThirdPartyTicket;

/**
 * 打印机组mapper
 * 
 * @author 幸仁强
 */
@Component
public class WeChatJsSdkInitDao implements IWeChatJsSdkInitDao
{
    @Override
    public ThirdPartyAccessToken getAccessToken(int partnerId)
        throws Exception
    {
        ThirdPartyAccessToken thirdPartyAccessToken = new ThirdPartyAccessToken();
        thirdPartyAccessToken.setPartnerId(partnerId);
        return CouchBaseFactory.get(ThirdPartyAccessToken.class, thirdPartyAccessToken.key());
    }

    @Override
    public boolean updateAccessToken(ThirdPartyAccessToken thirdPartyAccessToken)
        throws Exception
    {
        return CouchBaseFactory.update(thirdPartyAccessToken, CommonConst.MINUTE_110);
    }

    @Override
    public ThirdPartyTicket getTicket(int partnerId)
        throws Exception
    {
        ThirdPartyTicket thirdPartyTicket = new ThirdPartyTicket();
        thirdPartyTicket.setPartnerId(partnerId);
        return CouchBaseFactory.get(ThirdPartyTicket.class, thirdPartyTicket.key());
    }

    @Override
    public boolean updateTicket(ThirdPartyTicket thirdPartyTicket)
        throws Exception
    {
        return CouchBaseFactory.update(thirdPartyTicket, CommonConst.MINUTE_110);
    }
}