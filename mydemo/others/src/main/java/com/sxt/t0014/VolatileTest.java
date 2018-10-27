package com.sxt.t0014;

public class VolatileTest {
    private volatile int a = 1;
    private int i = 0;

    /**
     * 如果a不加volatile关健字，则p2方法改变了a的值，但p方法依然不会停止
     */
    public void p(){
        try {
            while (a == 1) {
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void p2(){
        try {
            Thread.sleep(5000);
            a = 20;
            System.out.println("change p");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        VolatileTest v = new VolatileTest();
        Thread t1 = new Thread(()->{v.p();});
        t1.start();
        Thread t2 = new Thread(()->{v.p2();});
        t2.start();
    }
}
