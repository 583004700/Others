package com.sxt.t040.zookeeper;

import org.apache.zookeeper.*;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ZookeeperBase {
    static final String CONNECT_ADDR = "192.168.0.107:2181,192.168.0.108:2181,192.168.0.109:2181";
    static final int SESSION_OUTTIME = 5000;
    static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static void main(String[] args) throws Exception{
        ZooKeeper zk = new ZooKeeper(CONNECT_ADDR, SESSION_OUTTIME, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("执行event--------------");
                Event.KeeperState keeperState = watchedEvent.getState();
                Event.EventType eventType = watchedEvent.getType();
                if(Event.KeeperState.SyncConnected == keeperState){
                    if(Event.EventType.None == eventType){

                        System.out.println("zk建立连接");
                        countDownLatch.countDown();
                    };
                }
            }
        });
        countDownLatch.await();
        //String ret = zk.create("/testRoot","testRoot1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        //创建子节点，临时节点，本次会话有效
        zk.exists("/testRoot/children", true);
        String ret = zk.create("/testRoot/children","children data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL);
        System.out.println(ret);
//        zk.delete("/testRoot/children",-1);
//        String s = new String(zk.getData("/testRoot",false,null));
//        System.out.println(s);
        //List<String> list = zk.getChildren("/testRoot",false);
        //list.forEach((o)->System.out.println(o));
        //zk.setData("/testRoot","aeiou".getBytes(),-1);
        //System.out.println(zk.exists("/testRoot",false));
        Thread.sleep(100000);
        zk.close();
    }
}
