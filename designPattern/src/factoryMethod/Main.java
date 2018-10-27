package factoryMethod;

import proxy.Proxy;
import proxy.SchoolGirl;

import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        IFactory leiFengFactory = new UndergraduateFactory();
        LeiFeng leiFeng = leiFengFactory.createLeiFeng();
        leiFeng.buyRice();
        leiFeng.sweep();
        leiFeng.wash();
    }
}
