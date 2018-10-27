package basebasicbolt;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

//如果继承的是BaseBasicBolt，则抛出FailedException异常就会回调fail方法
public class Bolt1 extends BaseBasicBolt {

    @Override
    public void execute(Tuple tuple,BasicOutputCollector collector) {
        collector.emit(new Values(tuple.getString(0)));
        System.out.println("bolt1的execute方法被调用一次"+tuple.getString(0));
    }


    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("uuid"));
    }

}
