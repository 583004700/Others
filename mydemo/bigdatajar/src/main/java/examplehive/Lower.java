package examplehive;

import org.apache.hadoop.hive.ql.exec.UDF;

public class Lower extends UDF{
    //add jar /root/apps/hadoop/bigdatajar-0.0.1-SNAPSHOT.jar 引入自己写的jar
    //create temporary function tolowcase as 'examplehive.Lower' 创建临时函数
    //drop temporary function tolowcase 删除临时函数
    //hive自定义函数
    public String evaluate(String s){
        if(null != s){
            return s.toLowerCase();
        }
        return s;
    }
}
