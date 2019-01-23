package zhongji.a17.container;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class TestMap {
    public static void main(String[] args) {
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<String,String>();
        linkedHashMap.put("b","b");
        linkedHashMap.put("a","a");
        linkedHashMap.put("z","z");
        linkedHashMap.put("m","m");
        System.out.println(linkedHashMap);

        HashMap<String,String> hashMap = new HashMap<String,String>();
        hashMap.put("b","b");
        hashMap.put("a","a");
        hashMap.put("z","z");
        hashMap.put("m","m");
        System.out.println(hashMap);
    }
}
