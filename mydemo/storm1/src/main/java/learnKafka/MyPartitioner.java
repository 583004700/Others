package learnKafka;

import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;

public class MyPartitioner implements Partitioner {
    public MyPartitioner(VerifiableProperties properties) {
    }
    public int partition(Object key, int numPartitions) {
        return 2;
    }
}
