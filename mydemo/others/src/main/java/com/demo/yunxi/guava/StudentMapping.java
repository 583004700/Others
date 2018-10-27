package com.demo.yunxi.guava;

public class StudentMapping extends BaseCache<String,Integer>{
    @Override
    protected Integer loadData(String s) {
        System.out.println(s);
        return 6;
    }
}
