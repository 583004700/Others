package com.ry.xk.main.service;

import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.xk.common.bo.SystemConfig;
import com.ry.xk.common.service.SystemConfigService;
import com.ry.xk.main.bo.Partner;
import com.ry.xk.main.dao.IPartnerDao;
import com.ry.xk.request.bo.AuthInfoApiReqeust;
import com.ry.xk.request.bo.WxInitApiReqeust;
import com.ry.xk.response.bo.WeChatJsSdkInitParameterModel;
import com.ry.xk.studentexamresult.bo.ThirdPartyAccessToken;
import com.ry.xk.studentexamresult.bo.ThirdPartyTicket;
import com.ry.xk.utils.CryptogramHelper;
import com.ry.xk.utils.DateUtil;
import com.ry.xk.utils.JwtHelper;
import com.ry.xk.utils.WeChatHelper;

/**
 * 授权业务类
 * 
 * @ClassName: AuthService
 * @author 幸仁强
 * @date 2018年5月29日
 */
@Service
public class AuthService implements IAuthService
{
    private static final Logger log = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    IPartnerDao partnerDao;

    @Autowired
    IUserService userService;

    @Autowired
    IWCFService wcfService;

    @Autowired
    SystemConfigService systemConfigService;

    @Autowired
    IWeChatJsSdkInitService weChatJsSdkInitService;

    @Override
    public String getTokenStr(AuthInfoApiReqeust authInfoApiReqeust)
        throws Exception
    {
        Partner partner = partnerDao.get(authInfoApiReqeust.getPartnerId());
        if (null != partner)
        {
            String openId = wcfService.getOpenId(partner.getWeChatAppId(), partner.getWeChatAppSecret(), authInfoApiReqeust.getCode());
            int userId = userService.checkAndBindUser(partner.getPartnerId(), openId);
            if (userId > 0)
            {
                return JwtHelper.createJWT(userId);
            }
            log.error(String.format("根据partnerId为%s，openId为%s生成绑定用户数据失败", authInfoApiReqeust.getPartnerId(), openId));
        }
        log.error(String.format("根据partnerId为%s查询合作伙伴为空", authInfoApiReqeust.getPartnerId()));
        throw new NullPointerException();
    }

    @Override
    public WeChatJsSdkInitParameterModel getWeChatJsSdkInfo(WxInitApiReqeust request)
        throws Exception

    {
        Partner partner = partnerDao.get(request.getPartnerId());
        ThirdPartyAccessToken accessTokenResult = weChatJsSdkInitService.getWaChatAccessToken(partner);
        if (null == accessTokenResult || StringUtils.isBlank(accessTokenResult.getAccessToken()))
        {
            log.error(String.format("获取微信accesstoken失败,partnerId为%s", request.getPartnerId()));
            throw new NullPointerException();
        }
        ThirdPartyTicket ticketResult = weChatJsSdkInitService.getWaChatTicket(request.getPartnerId(), accessTokenResult.getAccessToken());
        if (null == ticketResult || StringUtils.isBlank(ticketResult.getTicket()))
        {
            log.error(String.format("获取微信ticket失败,partnerId为%s,Accesstoken为", accessTokenResult.getAccessToken()));
            throw new NullPointerException();
        }
        SystemConfig systemConfig = systemConfigService.systemConfigs();
        String noncestr = UUID.randomUUID().toString().replaceAll("\\-", "");
        String timestamp = String.valueOf(DateUtil.getWeixinDateTime(new Date()));
        String signature = WeChatHelper.weChatSignature(noncestr, ticketResult.getTicket(), timestamp, request.getUrl());
        WeChatJsSdkInitParameterModel weChatJsSdkInitParameterModel = new WeChatJsSdkInitParameterModel();
        weChatJsSdkInitParameterModel.setAppId(CryptogramHelper.decryptThreeDESECB(partner.getWeChatAppId(), systemConfig.getConfigKey()));
        weChatJsSdkInitParameterModel.setNonceStr(noncestr);
        weChatJsSdkInitParameterModel.setSignature(signature);
        weChatJsSdkInitParameterModel.setTimestamp(timestamp);
        return weChatJsSdkInitParameterModel;
    }
}
