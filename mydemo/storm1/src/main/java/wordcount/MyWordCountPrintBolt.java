package wordcount;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;

import java.util.HashMap;

public class MyWordCountPrintBolt extends BaseBasicBolt{
    HashMap<String,Integer> wordCountMap = new HashMap<String, Integer>();

    public void execute(Tuple tuple, BasicOutputCollector basicOutputCollector) {
        System.out.println(Thread.currentThread().getName()+"------------start");
        String word = (String)tuple.getValueByField("word");
        Integer num = (Integer)tuple.getValueByField("num");
        Integer mnum = wordCountMap.get(word);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(mnum == null || mnum == 0){
            wordCountMap.put(word,num);
        }else{
            wordCountMap.put(word,mnum+num);
        }
        System.out.println(wordCountMap);
        System.out.println(Thread.currentThread().getName()+"------------end");
    }

    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {

    }
}
