package com.sxt.t0014;

public class MultiThread {
    private static int num = 0;

    /**
     * 如果不加static，每个对象都有一把锁，不能保证不同对象间的线程安全
     * @param tag
     */
    public static synchronized void printNum(String tag){
        try{
            if(tag.equals("a")){
                num = 100;
                System.out.println("tag a, set num over!");
                Thread.sleep(1000);
            }else {
                num = 200;
                System.out.println("tag b, set num over!");
            }
            System.out.println("tag "+tag +",num="+num);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final MultiThread m1 = new MultiThread();
        final MultiThread m2 = new MultiThread();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                m1.printNum("a");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                m2.printNum("b");
            }
        });

        t1.start();
        t2.start();
    }
}