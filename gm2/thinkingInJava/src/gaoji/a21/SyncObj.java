package gaoji.a21;

class T implements Runnable{
    public volatile Integer lock = 0;

    @Override
    public void run() {
        synchronized (this.lock){
            for (int i = 0; i < 10000; i++) {
                System.out.println(Thread.currentThread().getName()+":"+lock++);
            }
        }
    }
}

public class SyncObj {
    public static void main(String[] args) {
        T t1 = new T();
        T t2 = new T();
        new Thread(t1,"1").start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //t2.lock = 20;
        new Thread(t2,"2").start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.lock = 20;
    }
}
