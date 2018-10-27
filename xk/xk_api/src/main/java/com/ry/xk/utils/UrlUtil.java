package com.ry.xk.utils;

import java.io.UnsupportedEncodingException;

import org.apache.commons.beanutils.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ry.xk.common.CommonConst;
import com.ry.xk.studentexamresult.service.ExamPaperService;

/**
 * URL转码工具类
 * 
 * @ClassName: UrlUtil
 * @author 幸仁强
 * @date 2018年5月29日
 */
public class UrlUtil
{
    private final static String ENCODE = "UTF-8";

    private static final Logger log = LoggerFactory.getLogger(UrlUtil.class);

    /**
     * URL 解码
     * 
     * @Title: getURLDecoderString
     * @author 幸仁强
     * @param str
     * @return
     */
    public static String getURLDecoderString(String str)
    {
        String result = "";
        if (null == str)
        {
            return "";
        }
        try
        {
            result = java.net.URLDecoder.decode(str, ENCODE).replace(" ", "+");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * URL 转码
     * 
     * @Title: getURLEncoderString
     * @author 幸仁强
     * @param str
     * @return
     */
    public static String getURLEncoderString(String str)
    {
        String result = "";
        if (null == str)
        {
            return "";
        }
        try
        {
            result = java.net.URLEncoder.encode(str, ENCODE);
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * ID加密
     * 
     * @Title: idEncrypt
     * @author 幸仁强
     * @param <T>
     * @param id
     * @param key
     * @return
     * @throws Exception
     */
    public static <T> String idEncrypt(final T id)
    {
        try
        {
            return getURLEncoderString(CryptogramHelper.encryptThreeDESECB(id.toString(), CommonConst.IDDESKEY));
        }
        catch (Exception e)
        {
            log.error(String.format("ID为%s加密失败", id), e);
            return "";

        }
    }

    /**
     * ID解密
     * 
     * @Title: idDecrypt
     * @author 幸仁强
     * @param <T>
     * @param idEncoderStr
     * @param key
     * @return
     * @throws Exception
     */
    public static <T> T idDecrypt(final String idEncoderStr, final Class<T> clazz)
    {
        try
        {
            String idStr = CryptogramHelper.decryptThreeDESECB(getURLDecoderString(idEncoderStr), CommonConst.IDDESKEY);

            return (T)ConvertUtils.convert(idStr, clazz);
        }
        catch (Exception e)
        {
            log.error(String.format("密文为%s的ID解密失败", idEncoderStr), e);
            return (T)ConvertUtils.convert("0", clazz);
        }
    }

    public static void main(String[] args)
        throws Exception
    {
        System.out.println(idEncrypt(1L));
        int id = idDecrypt("l4Z95At%2BFtc%3D", Integer.class);
        System.out.println(id);

    }

}
