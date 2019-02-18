package gaoji.a21;

class O{
    private Object o1 = new Object();
    private Object o2 = new Object();

    public void m1(){
        synchronized (o1){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2){
                System.out.println("m1");
            }
        }
    }

    public void m2(){
        synchronized (o2){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1){
                System.out.println("m2");
            }
        }
    }
}

class T1 extends Thread{
    private O o;

    public T1(O o){
        this.o = o;
    }

    @Override
    public void run() {
        o.m1();
    }
}

class T2 extends Thread{
    private O o;

    public T2(O o){
        this.o = o;
    }

    @Override
    public void run() {
        o.m2();
    }
}

public class Ss{

    public static void main(String[] args) {
        O o = new O();
        T1 t1 = new T1(o);
        T2 t2 = new T2(o);

        t1.start();
        t2.start();
    }
}
