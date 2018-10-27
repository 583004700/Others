package rocketmq;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerOrderly;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;

import java.util.List;

public class OrderConsumer1 {
    public static void main(String[] args) throws MQClientException,InterruptedException{
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("quickstart_consumer");
        consumer.setNamesrvAddr("192.168.0.107:9876;192.168.0.108:9876;192.168.0.109:9876;192.168.0.110:9876");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.subscribe("TopicQuickStart","*");
        consumer.setConsumeThreadMin(20);
        consumer.setConsumeThreadMax(20);
        consumer.setConsumeMessageBatchMaxSize(10); //每次拉取最大条数
        //consumer.setMessageModel(MessageModel.BROADCASTING); //设置广播消费
        consumer.registerMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeConcurrentlyContext) {
                try {
                    System.out.println("消息条数"+list.size());
                    for (int i = 0; i < list.size(); i++) {
                        MessageExt msg = list.get(i);
                        String topic = msg.getTopic();
                        String msgBody = new String(msg.getBody(), "UTF-8");
                        String tags = msg.getTags();
                        System.out.println(Thread.currentThread().getName() + "----" + msgBody);
                        Thread.sleep(5);
                    }
                    System.out.println(Thread.currentThread().getName() + "----" +"finish");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });

        consumer.start();
    }
}
