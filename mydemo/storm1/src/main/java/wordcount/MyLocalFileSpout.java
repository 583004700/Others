package wordcount;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyLocalFileSpout extends BaseRichSpout{
    private SpoutOutputCollector collector;
    private BufferedReader reader;

    //初始化方法
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector){
        this.collector = spoutOutputCollector;
        try {
            this.reader = new BufferedReader(new FileReader(new File("d:/storm/wordcount/1.log")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //会被循环调用
    public void nextTuple() {
        try {
            String line = reader.readLine();
            if(StringUtils.isNotBlank(line)){
                List<Object> list = new ArrayList<Object>();
                list.add(line);
                collector.emit(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("juzi"));
    }
}
