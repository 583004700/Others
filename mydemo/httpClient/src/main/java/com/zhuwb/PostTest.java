package com.zhuwb;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class PostTest {
    public static void main(String[] args) throws Exception{
        HttpPost httpPost = new HttpPost("http://127.0.0.1:8080/postTest");
        MyHttpClient httpClient = new MyHttpClient(httpPost);
        //httpClient.setRequestHead("Content-Type","application/x-www-form-urlencoded");
        httpClient.setRequestHead("Content-Type","application/json");
        List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
        list.add(new BasicNameValuePair("hello", "你不好"));
        String body = httpClient.sendHttpPost(null,"{\"hello\":\"你好\"}".getBytes());
        System.out.println(body);
    }
}
