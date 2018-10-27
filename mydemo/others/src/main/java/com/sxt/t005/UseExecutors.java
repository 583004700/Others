package com.sxt.t005;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class UseExecutors {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        Job job = new Job();
        executorService.scheduleWithFixedDelay(job,5,1, TimeUnit.MILLISECONDS);
    }
}

class Job implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<10000;i++) {
            System.out.println(i+":"+Thread.currentThread().getName() + ":run");
        }
    }
}
