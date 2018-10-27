package prototype.FTest;

import prototype.Resume;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        F f1 = new F();
//        f1.name = "张三";
//        System.out.println(f1.toJsonString());

        S s1 = new S();
        s1.name = "张三";
        s1.age = 15;
        System.out.println(s1.toJsonString1());

        s1.fs();
    }
}
