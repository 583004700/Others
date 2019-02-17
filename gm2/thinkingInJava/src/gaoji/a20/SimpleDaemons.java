package gaoji.a20;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable{

    @Override
    public void run() {
        while(true){
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread()+" "+this);
        }
    }

    public static void main(String[] args) throws Exception{
//        for(int i=0;i<10;i++){
//            Thread daemon = new Thread(new SimpleDaemons());
//            //设置为后台线程,主线程结束时，后台线程也会结束
//            daemon.setDaemon(true);
//            daemon.start();
//        }



        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 10; i++) {
            exec.execute(new SimpleDaemons());
        }

        System.out.println("All");
        TimeUnit.MILLISECONDS.sleep(1000);
    }
}

class DaemonThreadFactory implements ThreadFactory{
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
