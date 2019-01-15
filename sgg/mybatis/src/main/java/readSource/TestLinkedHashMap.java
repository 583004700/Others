package readSource;

import java.util.LinkedHashMap;
import java.util.Map;

class MyLinkedHashMap extends LinkedHashMap<Object,Object>{

    @Override
    protected boolean removeEldestEntry(Map.Entry<Object, Object> eldest) {
        System.out.println(eldest.getKey());

        if(size() > 3){
            return true;
        }

        return false;
    }
}

public class TestLinkedHashMap {
    public static void main(String[] args) {
        MyLinkedHashMap myLinkedHashMap = new MyLinkedHashMap();
        myLinkedHashMap.put(2,"一");
        myLinkedHashMap.put(1,"二");
        myLinkedHashMap.put(3,"三");
        myLinkedHashMap.put(4,"四");

        System.out.println(myLinkedHashMap);
    }
}
