package myresource;

import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Contain{
    private static int count;
    private static int[] datas = new int[5];
    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();
    private static ThreadLocal<Integer> sizeThreadL = new ThreadLocal<Integer>();
    private static AtomicReference<Integer> sizeReference = new AtomicReference<Integer>(0);
    public void incre() throws InterruptedException {
        //writeLock.lock();
        sizeThreadL.set(sizeReference.get());
        if(sizeReference.get() < datas.length) {
            if (sizeReference.compareAndSet(sizeThreadL.get(), sizeReference.get() + 1)) {
                datas[sizeThreadL.get()] = count;
                System.out.println("生产数据:" + count);
                count++;
            }
        }
        //writeLock.unlock();
    }
    public void sub() throws InterruptedException {
        //readLock.lock();
        sizeThreadL.set(sizeReference.get());
        if(sizeReference.get() > 0) {
            if (sizeReference.compareAndSet(sizeThreadL.get(), sizeReference.get() - 1)) {
                int data = datas[sizeThreadL.get()-1];
                //这里是安全的
                System.out.println("线程：" + Thread.currentThread() + new Date() + "消费数据:" + data);
            }
        }
        //readLock.unlock();
    }
}

class Producer extends Contain implements Runnable {
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                incre();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Contain implements Runnable {
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(100);
                sub();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class CasProducerConsumer {
    public static void main(String[] args) {
        Producer pr = new Producer();
        Thread p = new Thread(pr);
        p.start();
        Consumer cust = new Consumer();
        Thread t = new Thread(cust);
        Thread t2 = new Thread(cust);
        Thread t3 = new Thread(cust);
        Thread t4 = new Thread(cust);
        t.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
