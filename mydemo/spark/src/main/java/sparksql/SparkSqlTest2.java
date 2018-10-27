package sparksql;

import com.alibaba.fastjson.JSONObject;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import java.util.ArrayList;
import java.util.List;

public class SparkSqlTest2 {
    public static void main(String[] args) {

        SparkConf conf = new SparkConf().setAppName("sparkSql").setMaster("local[1]");

        JavaSparkContext sc = new JavaSparkContext(conf);

        SQLContext sqlContext = new org.apache.spark.sql.SQLContext(sc);

        JavaRDD<String> people = sc.textFile("hdfs://192.168.0.107:9000/people.json");

        String schemaString = "name age";

        List<StructField> fields = new ArrayList<StructField>();
        for (String fieldName : schemaString.split(" ")) {
            fields.add(DataTypes.createStructField(fieldName, DataTypes.StringType, true));
        }
        StructType schema = DataTypes.createStructType(fields);

        JavaRDD<Row> rowRDD = people.map(
                new Function<String, Row>() {
                    public Row call(String record) throws Exception {
                        JSONObject jo = JSONObject.parseObject(record);
                        return RowFactory.create(jo.getString("name"), jo.getString("age"));
                    }
                });

        DataFrame peopleDataFrame = sqlContext.createDataFrame(rowRDD, schema);

        peopleDataFrame.registerTempTable("people");

        DataFrame results = sqlContext.sql("SELECT name FROM people");

        results.show();

        List<String> names = results.javaRDD().map(new Function<Row, String>() {
            public String call(Row row) {
                return "Name: " + row.getString(0);
            }
        }).collect();
    }
}
