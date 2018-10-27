package com.sxt.t013.jvm;

public class Test01 {
    public static void main(String[] args) {
        //-XX:+PrintGC -Xms5m -Xmx20m -XX:+UseSerialGC -XX:+PrintGCDetails
        System.out.println("maxMemory:"+Runtime.getRuntime().maxMemory());
        System.out.println("freeMemory:"+Runtime.getRuntime().freeMemory());
        System.out.println("totalMemory:"+Runtime.getRuntime().totalMemory());
        byte[] b1 = new byte[1*1024*1024];
        System.out.println("分配了1M");
        System.out.println("maxMemory:"+Runtime.getRuntime().maxMemory());
        System.out.println("freeMemory:"+Runtime.getRuntime().freeMemory());
        System.out.println("totalMemory:"+Runtime.getRuntime().totalMemory());

        byte[] b2 = new byte[4*1024*1024];
        System.out.println("分配了4M");
        System.out.println("maxMemory:"+Runtime.getRuntime().maxMemory());
        System.out.println("freeMemory:"+Runtime.getRuntime().freeMemory());
        System.out.println("totalMemory:"+Runtime.getRuntime().totalMemory());

    }
}
