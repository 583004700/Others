package com.sxt.t0014.future;

public class Main {
    public static void main(String[] args) {
        FutureClient futureClient = new FutureClient();
        Data data = futureClient.doWork();
        System.out.println("其它事情");
        System.out.println("其它事情");
        System.out.println("其它事情");
        System.out.println("其它事情");
        String result = data.getRequest("请求参数");
        System.out.println(result);

    }
}
