package flowsum;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

import java.util.HashMap;

public class ProvincePartitioner extends Partitioner<Text,FlowBean>{

    private static HashMap<String,Integer> provinces = new HashMap<String, Integer>();

    static {
        provinces.put("135",0);
        provinces.put("136",1);
        provinces.put("137",2);
        provinces.put("138",3);
        provinces.put("139",4);
    }

    @Override
    public int getPartition(Text text, FlowBean flowBean, int i) {
        Integer code = provinces.get(text.toString().substring(0,3));
        if(code != null){
            return code;
        }
        return 5;
    }
}
