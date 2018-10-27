package com.sxt.t30.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consumer implements Runnable{
    //http://localhost:8161/admin/ 控制台 默认用户名和密码 admin admin
    public static void main(String[] args) throws Exception{
        Consumer c = new Consumer();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        t1.start();
        Thread.sleep(100);
        //t2.start();
        Thread.sleep(2000);
        System.out.println(t1.getState());
        System.out.println(t2.getState());
    }

    @Override
    public void run() {
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                    ActiveMQConnectionFactory.DEFAULT_PASSWORD, "tcp://localhost:61616");

            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(Boolean.FALSE, Session.CLIENT_ACKNOWLEDGE);
            Destination destination = session.createQueue("queue1");
            MessageConsumer messageConsumer = session.createConsumer(destination);

            for (int i = 0; ; i++) {
                TextMessage textMessage = (TextMessage) messageConsumer.receive();
                String str = textMessage.getText();
                System.out.println(str);
                textMessage.acknowledge();

                //Thread.sleep(Integer.MAX_VALUE);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
