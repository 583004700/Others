package com.sxt.t30.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Sender {
    public static void main(String[] args) throws Exception{
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD,"tcp://localhost:61616");

        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(Boolean.FALSE,Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("queue1");
        MessageProducer messageProducer = session.createProducer(null);
        //messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);

        for(int i=0;i<5;i++){
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText("我是消息内容，id为"+i);
            messageProducer.send(destination, textMessage, DeliveryMode.NON_PERSISTENT, i, 1000 * 100);
            //messageProducer.send(textMessage);
        }
        //session.commit();
        connection.close();

    }
}
