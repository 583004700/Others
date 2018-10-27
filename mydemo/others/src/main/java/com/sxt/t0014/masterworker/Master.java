package com.sxt.t0014.masterworker;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {
    private ConcurrentLinkedQueue<Task> tasks = new ConcurrentLinkedQueue<Task>();

    private Map<String,Thread> works = new HashMap<String,Thread>();

    private Map<Integer,Object> taskResults = new ConcurrentHashMap<Integer, Object>();

    public void init(){
        for(int i=0;i<1000;i++){
            Task task = new Task();
            task.setId(i+1);
            task.setName((i+1)+"name");
            task.setPrice(i+1);
            tasks.add(task);
        }

        for(int i=0;i<50;i++){
            Worker w = new Worker(tasks,taskResults);
            works.put(String.valueOf(i+1),w);
        }
    }

    public void exec(){
        Iterator<Map.Entry<String,Thread>> entry = works.entrySet().iterator();
        while(entry.hasNext()){
            Map.Entry<String,Thread> e = entry.next();
            e.getValue().start();
        }
    }

    public Map<Integer,Object> getTaskResults(){
        Iterator<Map.Entry<String,Thread>> entry = works.entrySet().iterator();
        while(entry.hasNext()){
            Map.Entry<String,Thread> e = entry.next();
            while(((Worker)e.getValue()).getState() != Thread.State.TERMINATED){

            }
        }
        return taskResults;
    }
}
