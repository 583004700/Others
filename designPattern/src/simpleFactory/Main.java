package simpleFactory;

import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("请输入数字A");
        int a = scan.nextInt();
        System.out.println("请选择运算符号(+-*/)");
        String b = scan.next();
        System.out.println("请输入数字B");
        int c = scan.nextInt();
        Operation operation = OperationFactory.createOperation(b);
        System.out.println("结果是："+operation.getResult(a,c));
    }
}
