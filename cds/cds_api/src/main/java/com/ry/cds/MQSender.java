package com.ry.cds;

import java.io.IOException;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ry.cds.amqp.bo.IAmqpStoredObject;

/**
 * MQ生产者类
 * 
 * @author 幸仁强
 *
 */
@Component
public class MQSender {

	@Autowired
	@Qualifier("myRabbitTemplete")
	RabbitTemplate myRabbitTemplete;
	@Autowired
	ConnectionFactory connectionFactory;

	public <T extends IAmqpStoredObject> void send(T t) throws IOException {
		// Connection connection = connectionFactory.createConnection();
		// Channel channel = connection.createChannel(false);
		// channel.queueDeclare(t.getQueueName(), true, false, false, null);
		this.myRabbitTemplete.convertAndSend(t.getQueueName(), t);
	}

}