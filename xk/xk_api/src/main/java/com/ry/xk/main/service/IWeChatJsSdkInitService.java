package com.ry.xk.main.service;

import com.ry.xk.main.bo.Partner;
import com.ry.xk.studentexamresult.bo.ThirdPartyAccessToken;
import com.ry.xk.studentexamresult.bo.ThirdPartyTicket;

/**
 * 公众号AccessToken业务接口
 * 
 * @ClassName: IAccessTokenService
 * @author 幸仁强
 * @date 2018年5月31日
 */
public interface IWeChatJsSdkInitService
{
    /**
     * 获取公众号AccessToken
     * 
     * @Title: getWaChatAccessToken
     * @author 幸仁强
     * @param partner
     * @return
     * @throws Exception
     */
    public ThirdPartyAccessToken getWaChatAccessToken(Partner partner)
        throws Exception;

    /**
     * 获取公众号Ticket
     * 
     * @Title: getWaChatTicket
     * @author 幸仁强
     * @param parentId
     * @param accessToken
     * @return
     * @throws Exception
     */
    public ThirdPartyTicket getWaChatTicket(int parentId, String accessToken)
        throws Exception;
}
