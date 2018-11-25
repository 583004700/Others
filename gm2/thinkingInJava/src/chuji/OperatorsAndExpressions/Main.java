package chuji.OperatorsAndExpressions;

public class Main {
    public static void main(String[] args){
        int x = 53;
        int r = ~x;
        System.out.println(r);
        int y = 22;
        System.out.println(x&y);
        System.out.println(x|y);
        System.out.println(x^y);

        /**
         * 移位运算符
         * <<左移运算
         * >>右移运算
         * >>>逻辑右移运算符(得到正数结果)
         */
        System.out.println(4<<2);
        System.out.println(-12>>2);
        byte a = -12;
        System.out.println(a>>>2);
    }
}
