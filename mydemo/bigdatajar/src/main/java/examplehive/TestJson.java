package examplehive;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestJson {
    public static void main(String[] args) {
        String jsonStr = "{\"b\":\"7.5\",\"a\":\"M (B)\",,\"c\":\"M (B)\"}";

        System.out.println("无序遍历结果：");
        JSONObject jsonObj = JSON.parseObject(jsonStr);
        for (Map.Entry<String, Object> entry : jsonObj.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        System.out.println("-------------------");
        System.out.println("有序遍历结果：");
        LinkedHashMap<String, String> jsonMap = JSON.parseObject(jsonStr, new TypeReference<LinkedHashMap<String,String>>() {
        });
        for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        System.out.println(new JsonToString().evaluate(jsonStr));

    }
}