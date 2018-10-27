package basebasicbolt;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.FailedException;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

public class Bolt3 extends BaseBasicBolt {

    @Override
    public void execute(Tuple tuple,BasicOutputCollector collector) {
        collector.emit(new Values(tuple.getString(0)));
        System.out.println("bolt3的execute方法被调用一次"+tuple.getString(0));
        //抛出异常
        throw new FailedException("异常");
    }


    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("uuid"));
    }

}
