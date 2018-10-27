package com.sxt.t0014.future;

public class Data {

    private boolean finish;

    private String result;

    private String queryParam;

    public String getRequest(String queryParam){
        this.queryParam = queryParam;
        if(getFinish()){
            return result;
        }else{
            return null;
        }
    }

    public synchronized void doWork(){
        System.out.println("正在处理中。。。");
        try {
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        result = queryParam+"处理完成";
        finish = true;
        notify();
    }

    public synchronized boolean getFinish(){
        if(!finish){
            try {
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return finish;
    }
}
