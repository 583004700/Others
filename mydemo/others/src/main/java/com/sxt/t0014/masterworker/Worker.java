package com.sxt.t0014.masterworker;

import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker extends Thread{

    ConcurrentLinkedQueue<Task> tasks;
    Map<Integer,Object> taskResults;

    public Worker(ConcurrentLinkedQueue<Task> tasks,Map<Integer,Object> taskResults){
        this.tasks = tasks;
        this.taskResults = taskResults;
    }

    @Override
    public void run() {
        Object result = null;
        Task task = tasks.poll();
        while(task != null){
            try {
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }
            result = task.getPrice() * 2;
            taskResults.put(task.getId(),result);
            task = tasks.poll();
        }
    }
}
