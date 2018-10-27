package t3;

public class Main {

    public static void main(String[] args) {
        MyThread a = new MyThread("a");
        MyThread b = new MyThread("b");
        MyThread c = new MyThread("c");
        a.start();
        b.start();
        c.start();
    }
}
