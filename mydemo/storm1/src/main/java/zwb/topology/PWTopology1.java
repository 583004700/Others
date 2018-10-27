package zwb.topology;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.topology.TopologyBuilder;
import zwb.bolt.PrintBolt;
import zwb.bolt.WriteBolt;
import zwb.spout.PWSpout;


public class PWTopology1 {

	public static void main(String[] args) throws Exception {
		//主机器启动storm nimbus &
		//从机器启动storm supervisor &
		//主机器启动控制台服务器storm ui &
		//提交jar storm jar /usr/local/storm1.jar zwb.topology.PWTopology1
		Config cfg = new Config();
		cfg.setNumWorkers(2);
		cfg.setDebug(true);
		
		
		TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout("spout", new PWSpout());
		builder.setBolt("print-bolt", new PrintBolt()).shuffleGrouping("spout");
		builder.setBolt("write-bolt", new WriteBolt()).shuffleGrouping("print-bolt");
		
		
		//1 本地模式
		LocalCluster cluster = new LocalCluster();
		cluster.submitTopology("top1", cfg, builder.createTopology());
		Thread.sleep(10000);
		cluster.killTopology("top1");
		cluster.shutdown();
		
		//2 集群模式
//		StormSubmitter.submitTopology("top1", cfg, builder.createTopology());
//		Thread.sleep(10000);
	}
}
