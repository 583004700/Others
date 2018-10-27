package com.sxt.t0014;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Queue {
    private LinkedList<Object> list = new LinkedList<Object>();
    private int min = 0;
    private int max;
    public AtomicInteger atomicInteger = new AtomicInteger(0);
    private Object lock = new Object();

    public Queue(int max) {
        this.max = max;
    }

    public void put(Object o){
        try {
            synchronized (lock) {
                if (atomicInteger.get() == max) {
                    lock.wait();
                }
                list.add(o);
                atomicInteger.incrementAndGet();
                System.out.println("添加了元素" + o);
                lock.notify();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Object take(){
        try {
            Object o = null;
            synchronized (lock) {
                if (atomicInteger.get() == min) {
                    lock.wait();
                }
                o = list.remove(0);
                atomicInteger.decrementAndGet();
                System.out.println("移除了元素" + o);
                lock.notify();
            }
            return o;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws Exception{
        Queue q = new Queue(5);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        q.put(i + 1);
                    }
                    Thread.sleep(5000);
                    for (int i = 10; i < 20; i++) {
                        q.put(i + 1);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        t.start();


        Thread.sleep(5000);
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true) {
                        q.take();
                        //Thread.sleep(2000);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        t2.start();
    }
}
