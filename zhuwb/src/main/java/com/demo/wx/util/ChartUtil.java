package com.demo.wx.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class ChartUtil {

    /**
     * 将文本消息发送给图灵机器人
     * @param inputStr 输入的字符串
     * @return 返回的字符串
     */
    public static String chartText(String inputStr){
        String outStr = "";
        try {
            String APIKEY = "8287a105bac44f2a94ecfbd95630d085";
            String question = inputStr;//这是上传给云机器人的问题
            //String INFO = URLEncoder.encode("北京今日天气", "utf-8");
            String INFO = URLEncoder.encode(question, "utf-8");
            String getURL = "http://www.tuling123.com/openapi/api?key=" + APIKEY + "&info=" + INFO;
            URL getUrl = new URL(getURL);
            HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
            connection.connect();

            // 取得输入流，并使用Reader读取
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            StringBuffer sb = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();
            // 断开连接
            connection.disconnect();
            outStr = sb.toString();
            JSONObject jsonObject = JSON.parseObject(outStr);
            outStr = jsonObject.getString("text");
        }catch (Exception e){
            e.printStackTrace();
        }

        return outStr;
    }
}
