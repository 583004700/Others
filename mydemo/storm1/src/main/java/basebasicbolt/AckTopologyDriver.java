package basebasicbolt;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.generated.StormTopology;
import backtype.storm.topology.TopologyBuilder;

public class AckTopologyDriver {
    public static void main(String[] args) {
        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("mySpout",new AckSpout());
        builder.setBolt("bolt1",new Bolt1(),1).shuffleGrouping("mySpout");
        builder.setBolt("bolt2",new Bolt2(),1).shuffleGrouping("bolt1");
        builder.setBolt("bolt3",new Bolt3(),1).shuffleGrouping("bolt2");
        builder.setBolt("bolt4",new Bolt4(),1).shuffleGrouping("bolt3");

        Config config = new Config();
        config.setNumWorkers(2);
        StormTopology stormTopology = builder.createTopology();

        LocalCluster localCluster = new LocalCluster();
        localCluster.submitTopology("wordcount",config,stormTopology);
    }
}
