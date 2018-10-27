package examplehive;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.LinkedHashMap;
import java.util.Map;

public class JsonToString extends UDF {

    //add jar /root/apps/hadoop/bigdatajar-0.0.1-SNAPSHOT.jar 引入自己写的jar
    //create temporary function tostr as 'examplehive.JsonToString' 创建临时函数
    //drop temporary function tostr 删除临时函数
    public String evaluate(String jsonStr){
        LinkedHashMap<String, String> jsonMap = JSON.parseObject(jsonStr, new TypeReference<LinkedHashMap<String,String>>() {
        });
        String returnStr = "";
        for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
            returnStr += entry.getValue()+"\t";
        }
        return returnStr;
    }
}
