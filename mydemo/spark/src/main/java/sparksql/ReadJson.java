package sparksql;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;

public class ReadJson {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("readjson").setMaster("local[1]");

        JavaSparkContext sc = new JavaSparkContext(conf);

        SQLContext sqlContext = new org.apache.spark.sql.SQLContext(sc);
        //返回结构化数据
        DataFrame df = sqlContext.read().json("hdfs://192.168.0.107:9000/people.json");

        df.show();

        df.printSchema();

        df.select("age").show();

        df.select(df.col("name"), df.col("age").plus(1)).show();

        df.filter(df.col("age").gt(21)).show();

        df.groupBy("age").count().show();

        System.out.println("-------------------------sqlcontext.sql");
        df.registerTempTable("people");
        sqlContext.sql("select * from people p where p.name = 'zhangsan'").show();

    }
}
