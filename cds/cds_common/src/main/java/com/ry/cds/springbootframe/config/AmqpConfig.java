package com.ry.cds.springbootframe.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.ry.cds.common.CommonConst;

@Configuration
public class AmqpConfig {
	private static final Logger logger = LoggerFactory.getLogger(AmqpConfig.class);

	@Bean
	public Queue CdsUserAccountChangeQueue() {
		return new Queue(CommonConst.USERACCOUNTCHANGEQUEUE);
	}

	@Bean
	public Queue CdsPDFConvertPRNQueue() {
		return new Queue(CommonConst.PDFCONVERTPRNQUEUE);
	}

	@Bean
	public Queue CdsGeneralFileDataQueue() {
		return new Queue(CommonConst.GENERALFILEDATAQUEUE);
	}

	@Bean(name = "myRabbitTemplete")
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	RabbitTemplate myRabbitTemplete(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplete = new RabbitTemplate(connectionFactory);
		rabbitTemplete.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {

			@Override
			public void confirm(CorrelationData correlationData, boolean ack, String cause) {
				if (!ack) {
					logger.info("MQ消息发送失败，消息重发");
				} else {
					logger.info("MQ消息发送成功");
				}
			}
		});
		rabbitTemplete.setMessageConverter(new Jackson2JsonMessageConverter());
		return rabbitTemplete;
	}
}
