package com.demo;

import java.util.*;

public class Main {
    public static void main(String[] args){
        List<Map<String,Integer>> mapList = new ArrayList<Map<String,Integer>>();
        for(int i=0;i<100000;i++) {
            Map<String, Integer> map = new HashMap<String, Integer>();
            map.put("age",i);
            map.put("money",2*i);
            mapList.add(map);
        }
        System.out.println(System.currentTimeMillis()+"------------开始计算");

        Map<String, Integer> mapTotal = new HashMap<String, Integer>();
        Map<String,Integer> map = mapList.get(0);
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> e = iterator.next();
            int value = 0;
            for(int i=0;i<mapList.size();i++){
                value += mapList.get(i).get(e.getKey());
            }
            mapTotal.put(e.getKey(),value);
        }

        System.out.println(System.currentTimeMillis()+"--------------结束计算");
        System.out.println("age"+mapTotal.get("age")+"--------money"+mapTotal.get("money"));
    }
}
