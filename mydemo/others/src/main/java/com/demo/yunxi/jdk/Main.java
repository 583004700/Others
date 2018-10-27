package com.demo.yunxi.jdk;

public class Main {
    // -Xms64m -Xmx128m
    public static void main(String[] args) {
        test(0);
    }

    public static void test(int i){
        if(i == 15000){
            return;
        }
        test(i+1);
        System.out.println(i);
    }
}
