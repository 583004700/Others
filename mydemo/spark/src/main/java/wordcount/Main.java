package wordcount;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("wordcount").setMaster("local[2]");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> textFile = sc.textFile("d:/spark/wordcount/input/word.txt");
        JavaPairRDD<String, Integer> counts = textFile
                .flatMap(s -> Arrays.asList(s.split(" ")))
                .mapToPair(word -> new Tuple2<>(word, 1))
                .reduceByKey((a, b) -> a + b);
        counts.saveAsTextFile("d:/spark/wordcount/output/");

        counts.foreach((wordTuple) -> System.out.println(wordTuple._1+"----"+wordTuple._2));

        JavaRDD<String> lines=sc.textFile("d:/spark/wordcount/input/word.txt");
        JavaRDD<String> words = lines.flatMap(new FlatMapFunction<String,String>(){
            private static final long serialVersionUID = 1L;
            public Iterable<String> call(String line) throws Exception {
                return Arrays.asList(line.split(" "));
            }

        });
        JavaPairRDD<String,Integer> pairs =words.mapToPair(new PairFunction<String,String,Integer>(){
            private static final long serialVersionUID = 1L;
            public Tuple2<String, Integer> call(String word) throws Exception {
                return new Tuple2<String,Integer>(word,1);
            }
        });
        JavaPairRDD<String,Integer> wordCounts =pairs.reduceByKey(new Function2<Integer, Integer, Integer>(){
            private static final long serialVersionUID = 1L;
            public Integer call(Integer v1, Integer v2) throws Exception {
                return v1+v2;
            }

        });
        wordCounts.foreach(new VoidFunction<Tuple2<String,Integer>>(){
            private static final long serialVersionUID = 1L;
            public void call(Tuple2<String, Integer> wordcount) throws Exception {
                System.out.println(wordcount._1+" appeared "+wordcount._2+"times");
            }
        });
        sc.close();

        //map将回调函数的返回值直接加入到新集合中
//        List<String> arr= new ArrayList();
//        arr.add("wq");
//        arr = arr.stream().map((x)->{
//            return x+"55";
//        }).collect(Collectors.toList());
//        arr.forEach(x -> System.out.println(x));
//
//        ArrayList<ArrayList<String>> a = new ArrayList<ArrayList<String>>();
//        ArrayList<String> an = new ArrayList<String>();
//        a.add(an);
//        an.add("nihao");

        //flatMap将回调函数的返回值一一遍历，加入到新集合中
//        List<String> c = a.stream().flatMap((m)->{
//            return m.stream();
//        }).collect(Collectors.toList());
//        c.forEach(x -> System.out.println(x));
    }
}
