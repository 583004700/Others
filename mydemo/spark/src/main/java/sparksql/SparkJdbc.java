package sparksql;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class SparkJdbc {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("sparkJdbc").setMaster("local[1]");

        JavaSparkContext sc = new JavaSparkContext(conf);

        SQLContext sqlContext = new org.apache.spark.sql.SQLContext(sc);

        Map<String, String> options = new HashMap<String,String>();
        options.put("url", "jdbc:mysql://192.168.0.151:3306/jfinal_demo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        options.put("dbtable", "student");
        options.put("user","root");
        options.put("driver","com.mysql.jdbc.Driver");
        options.put("password","root");

        DataFrame jdbcDF = sqlContext.read().format("jdbc"). options(options).load();
        jdbcDF.show();
        jdbcDF.registerTempTable("student");

        Properties p = new Properties();
        p.setProperty("user","root");
        p.setProperty("password","root");
        //插入数据到mysql中
        sqlContext.sql("select * from student").write().mode("overwrite").jdbc("jdbc:mysql://192.168.0.151:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","student",p);
        sc.close();
    }
}
