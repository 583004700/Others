package wait_notify_size5;

public class MyThread2 extends Thread{
    private Object lock;
    public MyThread2(Object lock){
        this.lock = lock;
    }

    @Override
    public void run(){
        try {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    MyList.addString();
                    if (MyList.size() == 5) {
                        lock.notify();
                        System.out.println("通知已发出");
                    }
                    System.out.println("添加了第" + (i + 1) + "个元素");
                    Thread.sleep(1000);
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
