package wordcount;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestRddJ {
    SparkConf conf = new SparkConf().setAppName("wordcount").setMaster("local[2]");
    JavaSparkContext sc = new JavaSparkContext(conf);

    public static void main(String[] args) {
        TestRddJ testRdd = new TestRddJ();
        //testRdd.testMap();
        //testRdd.testFlatMap();
        testRdd.testMapPartition();
    }

    public void testMap(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        JavaRDD<Integer> data = sc.parallelize(list,2);
        JavaRDD<Integer> mapRdd = data.map((x)-> {return x*2;});
        mapRdd.foreach(x->System.out.println(x));
    }

    public void testFlatMap(){
        List<String> list = new ArrayList<String>();
        list.add("hello tom");
        list.add("hello lilei");
        list.add("hello hanmeimei");
        JavaRDD<String> data = sc.parallelize(list);
        JavaRDD<String> flatMap = data.flatMap(x-> Arrays.asList(x.split(" ")));
        flatMap.foreach(x->System.out.println(x));
    }

    public void testMapPartition(){
        List<String> list = Arrays.asList("hello tom","hello lilei","hello hanmeimei");
        JavaRDD<String> data = sc.parallelize(list,2);
        JavaRDD<String> map = data.map(x -> {
            System.out.println("--------"+x);
            return x;
        });
        map.count();
        System.out.println("-----------------------partition");

        data.mapPartitions(x->{
            while(x.hasNext()){
                System.out.println(x.next());
            }
            return new ArrayList<String>();
        }).count();
    }
}
