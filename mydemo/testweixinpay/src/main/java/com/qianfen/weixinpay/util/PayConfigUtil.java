package com.qianfen.weixinpay.util;

public interface PayConfigUtil {
    String APP_ID = "wx632c8f211f8122c6"; //微信公众号ID
    String MCH_ID = "1497984412"; //商户ID
    String API_KEY = "sbNCm1JnevqI36LrEaxFwcaT0hkGxFnC"; //API密钥
    String UFDOOER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder"; //微信统一下单地址
    String NOTIFY_URL = "http://pic.chenjunbo.xin/payment/result"; //回调地址，暂时不用
    String CREATE_IP = "117.44.179.175"; //发起IP

}
