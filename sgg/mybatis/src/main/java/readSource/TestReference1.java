package readSource;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

class Test implements Runnable{
    public ReferenceQueue referenceQueue = new ReferenceQueue();

    public WeakReference weakReference;

    @Override
    public void run() {
        Object o = new Object();

        weakReference = new WeakReference(o,referenceQueue);

        System.gc();

        try {
            Thread.sleep(2000);
            System.out.println(referenceQueue.poll());
        }catch (Exception e){

        }
    }
}

public class TestReference1 {
    public static void main(String[] args) throws Exception{
        Test test = new Test();

        Thread t = new Thread(test);
        t.start();

        Thread.sleep(3000);
        System.gc();
        Thread.sleep(1000);

        System.out.println(test.referenceQueue.poll());
    }
}
