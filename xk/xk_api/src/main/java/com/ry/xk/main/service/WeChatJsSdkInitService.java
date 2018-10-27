package com.ry.xk.main.service;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.xk.main.bo.Partner;
import com.ry.xk.main.dao.IPartnerDao;
import com.ry.xk.main.dao.IWeChatJsSdkInitDao;
import com.ry.xk.studentexamresult.bo.ThirdPartyAccessToken;
import com.ry.xk.studentexamresult.bo.ThirdPartyTicket;

/**
 * 公众号AccessToken业务类
 * 
 * @ClassName: IAccessTokenService
 * @author 幸仁强
 * @date 2018年5月31日
 */
@Service
public class WeChatJsSdkInitService implements IWeChatJsSdkInitService
{
    private static final Logger log = LoggerFactory.getLogger(WeChatJsSdkInitService.class);

    private static Lock lock = new ReentrantLock();

    @Autowired
    IWeChatJsSdkInitDao weChatJsSdkInitDao;

    @Autowired
    IPartnerDao partnerDao;

    @Autowired
    IWCFService wcfService;

    @Override
    public ThirdPartyAccessToken getWaChatAccessToken(Partner partner)
        throws Exception
    {
        ThirdPartyAccessToken tpat1 = weChatJsSdkInitDao.getAccessToken(partner.getPartnerId());
        if (null != tpat1 && new Date().getTime() < tpat1.getRefreshTicks() + tpat1.getExpiresIn() * 1000)
        {
            return tpat1;
        }
        lock.lock();
        ThirdPartyAccessToken tpat2 = null;
        try
        {
            tpat2 = weChatJsSdkInitDao.getAccessToken(partner.getPartnerId());
            if (null == tpat2 || (null != tpat1 && tpat1.getAccessToken().equals(tpat2.getAccessToken())))
            {
                ThirdPartyAccessToken updateThirdPartyAccessTokenRequest = wcfService.getThirdPartyAccessToken(partner);
                tpat2 = weChatJsSdkInitDao.getAccessToken(partner.getPartnerId());
                if (null != updateThirdPartyAccessTokenRequest && (null == tpat2 || tpat2.getRefreshTicks() < updateThirdPartyAccessTokenRequest.getRefreshTicks()))
                {
                    weChatJsSdkInitDao.updateAccessToken(updateThirdPartyAccessTokenRequest);
                    return updateThirdPartyAccessTokenRequest;
                }
            }
        }
        catch (Exception e)
        {
            log.error(String.format("获取公众号accessToken时异常，partnerId为%s", partner.getPartnerId()), e);
        }
        finally
        {
            lock.unlock();
        }
        return tpat2;
    }

    @Override
    public ThirdPartyTicket getWaChatTicket(int parentId, String accessToken)
        throws Exception
    {
        ThirdPartyTicket tpt1 = weChatJsSdkInitDao.getTicket(parentId);
        if (null != tpt1 && new Date().getTime() < tpt1.getRefreshTicks() + tpt1.getExpiresIn() * 1000)
        {
            return tpt1;
        }
        lock.lock();
        ThirdPartyTicket tpt2 = null;
        try
        {
            tpt2 = weChatJsSdkInitDao.getTicket(parentId);
            if (null == tpt2 || (null != tpt1 && tpt1.getTicket().equals(tpt1.getTicket())))
            {
                ThirdPartyTicket updateThirdPartyTicketRequest = wcfService.getThirdPartyTicket(parentId, accessToken);
                tpt2 = weChatJsSdkInitDao.getTicket(parentId);
                if (null != updateThirdPartyTicketRequest && (null == tpt2 || tpt2.getRefreshTicks() < updateThirdPartyTicketRequest.getRefreshTicks()))
                {
                    weChatJsSdkInitDao.updateTicket(updateThirdPartyTicketRequest);
                    return updateThirdPartyTicketRequest;
                }
            }
        }
        catch (Exception e)
        {
            log.error(String.format("获取公众号Ticket时异常，partnerId为%s,accessToken为%s", parentId, accessToken), e);
        }
        finally
        {
            lock.unlock();
        }
        return tpt2;
    }

}
