package rocketmq;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.MessageQueueSelector;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageQueue;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Producer {
    public static void main(String[] args) throws MQClientException,InterruptedException{
        DefaultMQProducer producer = new DefaultMQProducer("quickstart_producer");
        producer.setNamesrvAddr("192.168.0.107:9876;192.168.0.108:9876;192.168.0.109:9876;192.168.0.110:9876");
        producer.start();
        CountDownLatch latch = new CountDownLatch(1);

        for(int i=0;i<300;i++){
            try {
                Message msg = new Message("TopicQuickStart","TagA",("Hello RocketMQ"+i).getBytes());
                SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
                    @Override
                    public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                        int index = (Integer)o;
                        return list.get(index);
                    }
                },1);
                System.out.println(sendResult);
            }catch (Exception e){
                e.printStackTrace();
                Thread.sleep(1000);
            }
        }

        for(int i=0;i<300;i++){
            try {
                Message msg = new Message("TopicQuickStart","TagA",("Hello RocketMQ"+i).getBytes());
                SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
                    @Override
                    public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                        int index = (Integer)o;
                        return list.get(index);
                    }
                },2);
                System.out.println(sendResult);
            }catch (Exception e){
                e.printStackTrace();
                Thread.sleep(1000);
            }
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<300;i++){
                    try {
                        Message msg = new Message("TopicQuickStart","TagB",("Hello RocketMQ"+i).getBytes());
                        SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
                            @Override
                            public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                                int index = (Integer)o;
                                return list.get(index);
                            }
                        },3);
                        System.out.println(sendResult);
                    }catch (Exception e){
                        e.printStackTrace();
                        //Thread.sleep(1000);
                    }
                }
                latch.countDown();
            }
        }).start();

        latch.await();
        producer.shutdown();
    }
}
