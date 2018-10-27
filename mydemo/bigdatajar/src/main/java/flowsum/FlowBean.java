package flowsum;

import org.apache.hadoop.io.WritableComparable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlowBean implements WritableComparable<FlowBean> {
    private Double uuid = Math.random();
    private long upFlow;
    private long downFlow;
    public long getUpFlow() {
        return upFlow;
    }

    public void setUpFlow(long upFlow) {
        this.upFlow = upFlow;
    }

    public long getDownFlow() {
        return downFlow;
    }

    public void setDownFlow(long downFlow) {
        this.downFlow = downFlow;
    }

    public long getSumFlow() {
        return upFlow + downFlow;
    }

    public FlowBean() {
    }

    public FlowBean(long upFlow, long downFlow) {
        this.upFlow = upFlow;
        this.downFlow = downFlow;
    }

    //序列化方法
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeDouble(uuid);
        dataOutput.writeLong(upFlow);
        dataOutput.writeLong(downFlow);
    }

    //反序列化方法
    //注意：字段的反序列化的顺序跟序列化的顺序必须保持一致
    public void readFields(DataInput dataInput) throws IOException {
        this.uuid = dataInput.readDouble();
        this.upFlow = dataInput.readLong();
        this.downFlow = dataInput.readLong();
    }

    @Override
    public String toString() {
        return upFlow+"\t"+downFlow+"\t"+getSumFlow();
    }

    public int compareTo(FlowBean o) {
        if(o.getSumFlow()-getSumFlow() == 0){
            return o.getUuid().compareTo(getUuid());
        }
        return (int)(o.getSumFlow()-getSumFlow());
    }

    public Double getUuid() {
        return uuid;
    }

    public void setUuid(Double uuid) {
        this.uuid = uuid;
    }
}
