package sparksql;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;

public class SparkSqlTest {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("sparkSql").setMaster("local[1]");

        JavaSparkContext sc = new JavaSparkContext(conf);

        SQLContext sqlContext = new org.apache.spark.sql.SQLContext(sc);
        //返回结构化数据
        DataFrame df = sqlContext.read().json("hdfs://192.168.0.107:9000/people.json");

        df.registerTempTable("people");

        sqlContext.sql("select * from people").show();

    }

    public static class Person{
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
