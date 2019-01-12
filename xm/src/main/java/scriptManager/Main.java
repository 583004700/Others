package scriptManager;

public class Main {
    /**
     * 查询的线程
     */
    static class QueryThread implements Runnable{
        @Override
        public void run() {
            try{
                System.out.println("开始查询");
                Thread.sleep(40000);
                System.out.println("查询结束");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                System.out.println("finally语句");
            }
        }
    }

    public static void main(String[] args) {
        QueryThread q = new QueryThread();
        Thread t1 = new Thread(q);
        t1.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.stop();

    }
}
