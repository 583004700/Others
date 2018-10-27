package com.demo.queue;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    private BlockingQueue<Integer> b1 = new ArrayBlockingQueue<Integer>(100);

    public static void main(String[] args) throws Exception{
        Main m = new Main();
        m.b1.add(1);
        m.b1.add(2);
        System.out.println(Arrays.asList(m.b1.toArray()));
        m.b1.put(3);
        System.out.println(Arrays.asList(m.b1.toArray()));
        m.b1.offer(4);
        m.b1.offer(5);
        m.b1.offer(6);
        m.b1.offer(7);
        System.out.println(Arrays.asList(m.b1.toArray()));
        m.b1.poll();
        System.out.println(Arrays.asList(m.b1.toArray()));
        m.b1.take();
        System.out.println(Arrays.asList(m.b1.toArray()));
        m.b1.remove();
        System.out.println(Arrays.asList(m.b1.toArray()));
        m.b1.peek();
        System.out.println(Arrays.asList(m.b1.toArray()));
    }
}
