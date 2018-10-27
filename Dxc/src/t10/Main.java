package t10;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
       PrintString printString = new PrintString();
       new Thread(printString).start();
       System.out.println("我要停止它！stopThread="+Thread.currentThread().getName());
       printString.setContinuePrint(false);
    }
}
