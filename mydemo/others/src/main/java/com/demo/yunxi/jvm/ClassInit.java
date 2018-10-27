package com.demo.yunxi.jvm;

public class ClassInit {
    public static void main(String[] args) {
        ClassLoader c = ClassInit.class.getClassLoader();
        while(c!=null){
            System.out.println(c);
            c = c.getParent();
        }
    }
}
