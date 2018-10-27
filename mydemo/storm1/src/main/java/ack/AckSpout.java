package ack;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

public class AckSpout extends BaseRichSpout{
    private SpoutOutputCollector collector;
    @Override
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector collector) {
        this.collector = collector;
    }

    @Override
    public void nextTuple() {
        String uuid = UUID.randomUUID().toString().replaceAll("_","");
        //发送的值和msgId
        collector.emit(new Values(uuid),uuid);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("uuid"));
    }

    @Override
    public void ack(Object msgId) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        System.out.println("消息处理成功");
    }

    @Override
    public void fail(Object msgId) {
        System.out.println("消息处理失败");
        //消息重发
        this.collector.emit(new Values(msgId));
    }
}
