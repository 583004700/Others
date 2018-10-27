package t7;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        System.out.println("begin =="+myThread.isAlive());
        myThread.start();
        System.out.println("end =="+myThread.isAlive());
        Random random = new Random();
        random.nextInt();

    }
}
