package strategy;

import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        CashContext cashContext = new CashContext("打八折");
        double result = cashContext.getResult(100);
        System.out.println("折扣后的价格是"+result);
    }
}
