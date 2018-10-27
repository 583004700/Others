package com.demo.yunxi.redis;

import java.util.concurrent.CountDownLatch;

public class Ticket {
    static CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void main (String[] args) throws Exception{
        for(int i=0;i<7;i++) {
            Thread t = new Thread(() -> {
                countDownLatch.countDown();
            });
            t.start();
        }

        countDownLatch.wait();
        Thread.sleep(1000);
        System.out.println(countDownLatch.getCount());
    }
}
