package com.demo.yunxi.forkjoin;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTotal {
    public static class Worker extends RecursiveTask<Map<String,Integer>>{

        private static final int THRESHOLD = 500;
        private int fromIndex;
        private int toIndex;
        List<Map<String,Integer>> mapList;

        public Worker(int fromIndex, int toIndex, List<Map<String, Integer>> mapList) {
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
            this.mapList = mapList;
        }

        @Override
        protected Map<String, Integer> compute() {
            if(toIndex - fromIndex < THRESHOLD){
                Map<String, Integer> mapTotal = new HashMap<String, Integer>();
                Map<String,Integer> map = mapList.get(0);
                Iterator<java.util.Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
                while(iterator.hasNext()){
                    java.util.Map.Entry<String, Integer> e = iterator.next();
                    int value = 0;
                    for(int i=fromIndex;i<toIndex;i++){
                        value += mapList.get(i).get(e.getKey());
                    }
                    mapTotal.put(e.getKey(),value);
                }
                return mapTotal;
            }else{
                int mid = (fromIndex+toIndex)/2;
                Worker worker1 = new Worker(fromIndex,mid,mapList);
                Worker worker2 = new Worker(mid,toIndex,mapList);
                invokeAll(worker1,worker2);
                Map<String, Integer> mapTotal = new HashMap<String, Integer>();
                Map<String, Integer> mapTotal1 = worker1.join();
                Map<String, Integer> mapTotal2 = worker2.join();
                mapTotal.put("age",mapTotal1.get("age")+mapTotal2.get("age"));
                mapTotal.put("money",mapTotal1.get("money")+mapTotal2.get("money"));
                return mapTotal;
            }
        }
    }

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

        System.out.println(System.currentTimeMillis()+"------------开始计算");
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Worker worker = new Worker(0,mapList.size(), mapList);
        forkJoinPool.invoke(worker);
        Map<String,Integer> totalMap = worker.join();
        System.out.println(System.currentTimeMillis()+"--------------结束计算");
        System.out.println("age"+totalMap.get("age")+"--------money"+totalMap.get("money"));
    }
}
