package com.common.util;

import com.alibaba.fastjson.JSON;

public class JsonUtil {
    public static String ObjectToJsonString(Object o){
        return JSON.toJSONString(o);
    }

    public static<T> T jsonStringToObject(String s,Class<T> c){
        return JSON.parseObject(s, c);
    }
}
