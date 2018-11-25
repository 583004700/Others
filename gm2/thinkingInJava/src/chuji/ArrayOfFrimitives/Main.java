package chuji.ArrayOfFrimitives;

import java.util.Arrays;

public class Main {
    public String m = "d";
    public String b = "d";
    public static void main(String[] args){
        int[] a1 = new int[10];
        Arrays.sort(a1);
        System.out.println("aeiou");

        String a = "ds";
        String b = "ds";
        System.out.println(a == b);

        Main m = new Main();

        Main1 m1 = new Main1();

        System.out.println(m.m == m1.b);
    }
}

class Main1{
    public String m = "d";
    public String b = "d";
}
