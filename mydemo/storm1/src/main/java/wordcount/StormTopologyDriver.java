package wordcount;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.generated.StormTopology;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;

public class StormTopologyDriver {
    public static void main(String[] args) {
        TopologyBuilder topologyBuilder = new TopologyBuilder();
        topologyBuilder.setSpout("MyLocalFileSpout",new MyLocalFileSpout());
        topologyBuilder.setBolt("MySplitBolt",new MySplitBolt(),8).shuffleGrouping("MyLocalFileSpout");
        topologyBuilder.setBolt("MyWordCountPrintBolt",new MyWordCountPrintBolt(),2).fieldsGrouping("MySplitBolt",new Fields("word"));

        //任务提交
        Config config = null;
        try {
            config = new Config();
            //设置jvm数量
            config.setNumWorkers(1);
            config.setDebug(true);
            StormTopology stormTopology = topologyBuilder.createTopology();

            //集群模式
           /* StormSubmitter.submitTopology("wordcount",config,stormTopology);*/
            //本地模式
            LocalCluster localCluster = new LocalCluster();
            localCluster.submitTopology("wordcount",config,stormTopology);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
