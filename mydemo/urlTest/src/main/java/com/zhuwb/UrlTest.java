package com.zhuwb;

import java.io.FileOutputStream;
import java.net.URL;

public class UrlTest {
    public static void main(String[] args) {
        URL url1 = UrlTest.class.getResource("/com/zhuwb");
        System.out.println("UrlTest.class.getResource(\"/com/zhuwb\")------------"+url1);

        URL url2 = UrlTest.class.getResource("");
        System.out.println("UrlTest.class.getResource(\"\")------------"+url2);

        URL url3 = UrlTest.class.getClassLoader().getResource("com/zhuwb");
        System.out.println("UrlTest.class.getClassLoader().getResource(\"com/zhuwb\")------------"+url3);

        URL url4 = UrlTest.class.getClassLoader().getResource("/");
        System.out.println("UrlTest.class.getClassLoader().getResource(\"/\")------------"+url4);
        try {
            System.out.println(url3.toString());
            FileOutputStream out = new FileOutputStream("a.txt");
            out.write(new String("你好").getBytes());
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        demo2();

    }

    public static void demo1(){
        int i = 1/0;
    }

    public static void demo2(){
        demo1();
    }
}
