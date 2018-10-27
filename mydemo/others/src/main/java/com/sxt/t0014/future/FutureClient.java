package com.sxt.t0014.future;

public class FutureClient {

    public Data doWork(){
        System.out.println("开始处理");
        Data data = new Data();
        new Thread(new Runnable() {
            @Override
            public void run() {
                data.doWork();
            }
        }).start();
        return data;
    }
}
