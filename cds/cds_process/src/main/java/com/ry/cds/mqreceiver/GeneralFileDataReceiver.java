package com.ry.cds.mqreceiver;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;
import com.ry.cds.amqp.bo.FileDataFormat;
import com.ry.cds.common.CommonConst;
import com.ry.cds.user.service.IGeneralFileDataService;
import com.ry.cds.utils.JsonUtils;

/**
 * MQ消费者类
 * 
 * @author Administrator
 *
 */
@Component
public class GeneralFileDataReceiver {
	private static final Logger logger = LoggerFactory.getLogger(GeneralFileDataReceiver.class);
	@Autowired
	IGeneralFileDataService generalFileDataService;
	@Autowired
	@Qualifier("myRabbitTemplete")
	RabbitTemplate myRabbitTemplete;

	@RabbitListener(queues = CommonConst.GENERALFILEDATAQUEUE)
	public void onMessage(Message message, Channel channel) throws Exception {
		String str = null;
		try {
			str = new String(message.getBody());
			if (StringUtils.isNotBlank(str)) {
				FileDataFormat data = JsonUtils.JsonToBean(str, FileDataFormat.class);
				generalFileDataService.writeToFile(data);
			}
		} catch (Exception e) {
			String errorQueue = message.getMessageProperties().getConsumerQueue() + "_error";
			channel.queueDeclare(errorQueue, true, false, false, null);
			myRabbitTemplete.convertAndSend(errorQueue, message);
			logger.info("===>MQ服务器发送过来的信息处理异常：{}", message);
		}
		channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
	}

}