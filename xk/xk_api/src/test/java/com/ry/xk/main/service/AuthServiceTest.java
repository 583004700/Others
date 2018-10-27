package com.ry.xk.main.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.never;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ry.xk.Application;
import com.ry.xk.main.bo.Partner;
import com.ry.xk.main.dao.IPartnerDao;
import com.ry.xk.request.bo.AuthInfoApiReqeust;
import com.ry.xk.request.bo.WxInitApiReqeust;
import com.ry.xk.response.bo.WeChatJsSdkInitParameterModel;
import com.ry.xk.studentexamresult.bo.ThirdPartyAccessToken;
import com.ry.xk.studentexamresult.bo.ThirdPartyTicket;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class AuthServiceTest
{

    @Mock
    IPartnerDao partnerDao;

    @Mock
    IUserService userService;

    @Mock
    IWCFService wcfService;

    @Mock
    IWeChatJsSdkInitService weChatJsSdkInitService;

    @Before
    public void setUp()
        throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @Autowired
    @InjectMocks
    IAuthService authService;

    /**
     * token生成成功
     * 
     * @Title: getTokenStrSuccess
     * @author 幸仁强
     * @throws Exception
     */
    @Test
    public void getTokenStrSuccess()
        throws Exception
    {
        Partner partner = new Partner();
        partner.setPartnerId(1);
        partner.setWeChatAppId("LERtJtJ+Zx0=");
        partner.setWeChatAppSecret("appSecret");
        Mockito.when(partnerDao.get(Mockito.any(Integer.class))).thenReturn(partner);
        Mockito.when(wcfService.getOpenId(Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class))).thenReturn("openId");
        Mockito.when(userService.checkAndBindUser(Mockito.any(Integer.class), Mockito.any(String.class))).thenReturn(1);
        AuthInfoApiReqeust authInfoApiReqeust = new AuthInfoApiReqeust();
        String token = authService.getTokenStr(authInfoApiReqeust);
        assertNotNull(token);
    }

    /**
     * Token生成失败
     * 
     * @Title: getTokenStrErrorWhenPartnerIsNull
     * @author 幸仁强
     * @throws Exception
     */
    @Test(expected = NullPointerException.class)
    public void getTokenStrErrorWhenPartnerIsNull()
        throws Exception
    {
        Partner partner = new Partner();
        partner.setPartnerId(1);
        partner.setWeChatAppId("LERtJtJ+Zx0=");
        partner.setWeChatAppSecret("appSecret");
        Mockito.when(partnerDao.get(Mockito.any(Integer.class))).thenReturn(null);
        Mockito.when(wcfService.getOpenId(Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class))).thenReturn("openId");
        Mockito.when(userService.checkAndBindUser(Mockito.any(Integer.class), Mockito.any(String.class))).thenReturn(1);
        authService.getTokenStr(new AuthInfoApiReqeust());
        Mockito.verify(wcfService, never()).getOpenId(Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class));

    }

    /**
     * Token生成失败
     * 
     * @Title: getTokenStrErrorWhenUserIdIsNull
     * @author 幸仁强
     * @throws Exception
     */
    @Test(expected = NullPointerException.class)
    public void getTokenStrErrorWhenUserIdIsNull()
        throws Exception
    {
        Partner partner = new Partner();
        partner.setPartnerId(1);
        partner.setWeChatAppId("LERtJtJ+Zx0=");
        partner.setWeChatAppSecret("appSecret");
        Mockito.when(partnerDao.get(Mockito.any(Integer.class))).thenReturn(partner);
        Mockito.when(wcfService.getOpenId(Mockito.any(String.class), Mockito.any(String.class), Mockito.any(String.class))).thenReturn("openId");
        Mockito.when(userService.checkAndBindUser(Mockito.any(Integer.class), Mockito.any(String.class))).thenReturn(0);
        authService.getTokenStr(new AuthInfoApiReqeust());
        Mockito.verify(userService).checkAndBindUser(Mockito.any(Integer.class), Mockito.any(String.class));

    }

    /**
     * 获取微信网页JSSDK 参数初始化成功
     * 
     * @Title: getWeChatJsSdkInfoSuccess
     * @author 幸仁强
     * @throws Exception
     */
    @Test
    public void getWeChatJsSdkInfoSuccess()
        throws Exception
    {
        Partner partner = new Partner();
        partner.setPartnerId(1);
        partner.setWeChatAppId("LERtJtJ+Zx0=");
        partner.setWeChatAppSecret("appSecret");
        Mockito.when(partnerDao.get(Mockito.any(Integer.class))).thenReturn(partner);
        ThirdPartyAccessToken thirdPartyAccessToken = new ThirdPartyAccessToken();
        thirdPartyAccessToken.setAccessToken("accessToken");
        Mockito.when(weChatJsSdkInitService.getWaChatAccessToken(Mockito.any(Partner.class))).thenReturn(thirdPartyAccessToken);
        ThirdPartyTicket thirdPartyTicket = new ThirdPartyTicket();
        thirdPartyTicket.setTicket("ticket");
        Mockito.when(weChatJsSdkInitService.getWaChatTicket(Mockito.any(Integer.class), Mockito.any(String.class))).thenReturn(thirdPartyTicket);
        WxInitApiReqeust wxInitApiReqeust = new WxInitApiReqeust();
        wxInitApiReqeust.setUrl("url");
        WeChatJsSdkInitParameterModel weChatJsSdkInitParameterModel = authService.getWeChatJsSdkInfo(wxInitApiReqeust);
        assertNotNull(weChatJsSdkInitParameterModel);
    }

    /**
     * 获取微信网页JSSDK 参数初始化失败，accessToken为空
     * 
     * @Title: getWeChatJsSdkInfoWhenGetAccessTokenIsNull
     * @author 幸仁强
     * @throws Exception
     */
    @Test(expected = NullPointerException.class)
    public void getWeChatJsSdkInfoFailWhenGetAccessTokenIsNull()
        throws Exception
    {
        Partner partner = new Partner();
        partner.setPartnerId(1);
        partner.setWeChatAppId("LERtJtJ+Zx0=");
        partner.setWeChatAppSecret("appSecret");
        Mockito.when(partnerDao.get(Mockito.any(Integer.class))).thenReturn(partner);
        Mockito.when(weChatJsSdkInitService.getWaChatAccessToken(Mockito.any(Partner.class))).thenReturn(new ThirdPartyAccessToken());
        ThirdPartyTicket thirdPartyTicket = new ThirdPartyTicket();
        thirdPartyTicket.setTicket("ticket");
        Mockito.when(weChatJsSdkInitService.getWaChatTicket(Mockito.any(Integer.class), Mockito.any(String.class))).thenReturn(thirdPartyTicket);
        WxInitApiReqeust wxInitApiReqeust = new WxInitApiReqeust();
        wxInitApiReqeust.setUrl("url");
        authService.getWeChatJsSdkInfo(wxInitApiReqeust);
        Mockito.verify(wcfService, never()).getThirdPartyTicket(Mockito.any(Integer.class), Mockito.any(String.class));
    }

    /**
     * 获取微信网页JSSDK 参数初始化失败，accessToken为空
     * 
     * @Title: getWeChatJsSdkInfoSuccess
     * @author 幸仁强
     * @throws Exception
     */
    @Test(expected = NullPointerException.class)
    public void getWeChatJsSdkInfoFailWhenGetTicketIsNull()
        throws Exception
    {
        Partner partner = new Partner();
        partner.setPartnerId(1);
        partner.setWeChatAppId("LERtJtJ+Zx0=");
        partner.setWeChatAppSecret("appSecret");
        Mockito.when(partnerDao.get(Mockito.any(Integer.class))).thenReturn(partner);
        ThirdPartyAccessToken thirdPartyAccessToken = new ThirdPartyAccessToken();
        thirdPartyAccessToken.setAccessToken("accessToken");
        Mockito.when(weChatJsSdkInitService.getWaChatAccessToken(Mockito.any(Partner.class))).thenReturn(thirdPartyAccessToken);
        Mockito.when(weChatJsSdkInitService.getWaChatTicket(Mockito.any(Integer.class), Mockito.any(String.class))).thenReturn(new ThirdPartyTicket());
        WxInitApiReqeust wxInitApiReqeust = new WxInitApiReqeust();
        wxInitApiReqeust.setUrl("url");
        WeChatJsSdkInitParameterModel weChatJsSdkInitParameterModel = authService.getWeChatJsSdkInfo(wxInitApiReqeust);
        assertNotNull(weChatJsSdkInitParameterModel);
    }
}
