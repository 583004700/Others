package kafkastormredis;

import backtype.storm.task.TopologyContext;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by maoxiangyi on 2016/8/16.
 */
public class MyWordCountAndPrintBolt extends BaseBasicBolt {
    private Jedis jedis;
    private Map<String, Integer> wordCountMap = new HashMap<String, Integer>();

    @Override
    public void prepare(Map stormConf, TopologyContext context) {
        //连接redis---代表可以连接任何事物
        jedis = new Jedis("192.168.0.107", 6379);
        super.prepare(stormConf, context);
    }

    public void execute(Tuple tuple, BasicOutputCollector collector) {
        String word = (String)tuple.getValueByField("word");
        Integer num = (Integer)tuple.getValueByField("num");
        Integer mnum = wordCountMap.get(word);
        if(mnum == null || mnum == 0){
            wordCountMap.put(word,num);
        }else{
            wordCountMap.put(word,mnum+num);
        }
        System.out.println(wordCountMap);
        //2、保存数据到redis
        // redis key wordcount:->Map
//        jedis.hmset("wordcount",wordCountMap);
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        //todo 不需要定义输出的字段
    }
}
