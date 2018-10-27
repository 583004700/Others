package wordcount;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

public class MySplitBolt extends BaseBasicBolt{
    public void execute(Tuple tuple, BasicOutputCollector collector) {
        String juzi = (String)tuple.getValueByField("juzi");
        String[] strings = juzi.split(" ");
        for(String word:strings){
            //发送list对象
            collector.emit(new Values(word,1));
        }
    }

    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        //声明发送的键
        outputFieldsDeclarer.declare(new Fields("word","num"));
    }
}
