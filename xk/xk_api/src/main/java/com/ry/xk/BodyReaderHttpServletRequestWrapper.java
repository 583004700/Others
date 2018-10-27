package com.ry.xk;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.ry.xk.utils.JwtHelper;
import com.ry.xk.utils.UrlUtil;

import jodd.io.StreamUtil;

public class BodyReaderHttpServletRequestWrapper extends HttpServletRequestWrapper
{

    private byte[] body; // 用于保存读取body中数据

    public String param = "";

    public BodyReaderHttpServletRequestWrapper(HttpServletRequest httpRequest)
        throws Exception
    {
        super(httpRequest);
        body = StreamUtil.readBytes(httpRequest.getReader(), "UTF-8");
        param = this.getBodyString(this.getReader());
        Map<String, Object> map = JSON.parseObject(param);
        Cookie[] cookie = httpRequest.getCookies();
        if (null != cookie)
        {
            Cookie cook = Arrays.asList(cookie).stream().filter(switchEnum -> switchEnum.getName().equals("authorization")).findFirst().orElse(null);
            if (null != cook && StringUtils.isNotBlank(cook.getValue()) && null != JwtHelper.parseJWT(cook.getValue()))
            {
                int userId = JwtHelper.getUserId(cook.getValue());
                map.put("userId", userId);
            }
        }
        if (map.containsKey("orgId"))
        {
            int partnerId = UrlUtil.idDecrypt(map.get("orgId").toString(), Integer.class);
            map.put("partnerId", partnerId);
        }
        String json = JSON.toJSONString(map, true);
        body = StreamUtil.readBytes(new ByteArrayInputStream(json.getBytes("UTF-8")));

    }

    public static String getBodyString(BufferedReader br)
    {
        String inputLine;
        String str = "";
        try
        {
            while ((inputLine = br.readLine()) != null)
            {
                str += inputLine;
            }
            br.close();
        }
        catch (IOException e)
        {
            System.out.println("IOException: " + e);
        }
        return str;
    }

    @Override
    public BufferedReader getReader()
        throws IOException
    {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream()
        throws IOException
    {
        final ByteArrayInputStream bais = new ByteArrayInputStream(body);
        return new ServletInputStream()
        {

            @Override
            public int read()
                throws IOException
            {
                return bais.read();
            }

            @Override
            public boolean isFinished()
            {
                return false;
            }

            @Override
            public boolean isReady()
            {
                return false;
            }

            @Override
            public void setReadListener(ReadListener arg0)
            {}
        };
    }
}