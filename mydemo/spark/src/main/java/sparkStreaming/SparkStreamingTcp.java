package sparkStreaming;

import com.google.common.base.Optional;
import org.apache.spark.SparkConf;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import scala.Tuple2;

import java.util.Arrays;


public class SparkStreamingTcp {
    public static void main(String[] args){
        SparkConf conf = new SparkConf().setAppName("sparkStreamingTcp").setMaster("local[2]");
        //SparkContext sc = new SparkContext(conf);
        JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(5));
        jssc.checkpoint("./spark");
        //监听9999端口发过来的数据，相当于tcp客户端
        JavaReceiverInputDStream<String> lines = jssc.socketTextStream("192.168.0.107", 9999);

//        JavaPairDStream<String,Integer> wordCounts = lines.flatMap((x)-> Arrays.asList(x.split(" "))).
//                mapToPair(x->new Tuple2<String,Integer>(x,1)).reduceByKey((x, y)->x+y);
        JavaPairDStream<String,Integer> wordCounts = lines.flatMap((x)-> Arrays.asList(x.split(" "))).
                mapToPair(x->new Tuple2<String,Integer>(x,1)).updateStateByKey((x,y)->{
            //x表示新加的键的所有数据
            //y表示历史的值
            Integer oldCount = y.or(0);
            Integer newCount = 0;
            for(Integer i:x){
                newCount+=i;
            }
            System.out.println("x---------"+x);
            System.out.println("y---------"+y.or(0));
            return Optional.of(newCount+oldCount);
        });
        wordCounts.print();

        jssc.start();
        jssc.awaitTermination();
    }
}
