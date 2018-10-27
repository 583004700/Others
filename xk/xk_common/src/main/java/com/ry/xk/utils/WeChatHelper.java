package com.ry.xk.utils;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * 微信工具类
 * 
 * @ClassName: WeChatHelper
 * @author 幸仁强
 * @date 2018年5月31日
 */

public class WeChatHelper
{
    public static String weChatSignature(String noncestr, String ticket, String timestamp, String url)
        throws Exception
    {
        Map<String, String> dics = new HashMap<String, String>();
        dics.put("noncestr", noncestr);
        dics.put("jsapi_ticket", ticket);
        dics.put("timestamp", timestamp);
        dics.put("url", url);
        String jsapiTicket = getParamSrc(dics);
        return sha1(jsapiTicket);
    }

    /**
     * 按照ASCII码从小到大排序 <描述方法的作用>
     * 
     * @Title: getParamSrc
     * @author 幸仁强
     * @param paramsMap
     * @return
     */
    private static String getParamSrc(Map<String, String> paramsMap)
    {
        StringBuilder valueSb = new StringBuilder();
        // 将参数以参数名的字典升序排序
        Map<String, String> sortParams = new TreeMap<String, String>(paramsMap);
        Set<Entry<String, String>> entrys = sortParams.entrySet();
        // 遍历排序的字典,并拼接key1=value1&key2=value2......格式
        for (Entry<String, String> entry : entrys)
        {
            valueSb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        return valueSb.substring(0, valueSb.length() - 1);
    }

    /**
     * SHA1 加密，返回小写字符串
     * 
     * @Title: SHA1
     * @author 幸仁强
     * @param decript
     *            需要加密字符串
     * @return 返回40位小写字符串
     * @throws Exception
     */
    public static String sha1(String decript)
        throws Exception
    {
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(decript.getBytes("ASCII"));
            byte[] messageDigest = digest.digest();
            StringBuilder hexString = new StringBuilder();
            for (byte message : messageDigest)
            {
                String shaHex = Integer.toHexString(message & 0xFF);
                if (shaHex.length() < 2) hexString.append(0);
                hexString.append(shaHex);
            }
            return hexString.toString().replaceAll("\\-", "").toLowerCase();
        }
        catch (Exception e)
        {
            throw new Exception("SHA1加密出错：" + e.getMessage());
        }
    }
}
