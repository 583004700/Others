package com.sxt.t0014;

import java.util.concurrent.locks.ReentrantLock;

public class MyObject {

    public synchronized void m1(){
        System.out.println("m1");
        try {
            Thread.sleep(4000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void m2(){
        System.out.println("m2");
    }

    public static void main(String[] args) {
        final MyObject mo = new MyObject();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mo.m1();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                mo.m2();
            }
        });
        t1.start();
        t2.start();
    }
}
