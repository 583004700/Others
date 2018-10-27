package learnKafka;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Properties;

/**
 * Created by maoxiangyi on 2016/8/20.
 */
public class MyKafkaProducer {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("metadata.broker.list","192.168.0.107:9092");
        properties.put("serializer.class","kafka.serializer.StringEncoder");
        /**
         * 自定义parition的基本步骤
         * 1、实现partition类
         * 2、加一个构造器，MyPartitioner(VerifiableProperties properties)
         * 3、将自定义的parititoner加入到properties中
         *    properties.put("partitioner.class","cn.itcast.MyPartitioner")
         * 4、producer.send方法中必须指定一个paritionKey
         */
        //创建时须要指定parition数量
        properties.put("partitioner.class","learnKafka.MyPartitioner");
        Producer producer = new Producer(new ProducerConfig(properties));
        int i = 0;
        while (true) {
            producer.send(new KeyedMessage("test", "zhang"+i++, "我爱我的祖国"));
        }
    }
}
