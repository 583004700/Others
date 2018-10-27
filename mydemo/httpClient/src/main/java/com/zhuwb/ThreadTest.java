package com.zhuwb;

public class ThreadTest implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<1000 && !Thread.currentThread().isInterrupted();i++){
            System.out.println(Thread.currentThread().getName()+"------------"+i);
            if(i==100 && Thread.currentThread().getName().equals("t1")){
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(new ThreadTest(),"t1");
        t1.start();

        Thread t2 = new Thread(new ThreadTest(),"t2");
        t2.start();
        Thread.sleep(1000000);
    }
}
