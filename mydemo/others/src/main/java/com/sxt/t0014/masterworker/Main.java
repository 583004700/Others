package com.sxt.t0014.masterworker;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Master master = new Master();
        master.init();
        master.exec();
        Map<Integer,Object> results = master.getTaskResults();
        System.out.println(System.currentTimeMillis()-start);
        Map<Integer,Object> treeMap = new TreeMap<Integer,Object>(results);
        Iterator<Map.Entry<Integer,Object>> entry = treeMap.entrySet().iterator();
        while(entry.hasNext()){
            Map.Entry<Integer,Object> e = entry.next();
            Integer i = (Integer) e.getValue();
            System.out.println(e.getKey()+":"+i);
        }
    }
}
