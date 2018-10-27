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
import com.ry.cds.amqp.bo.UserAccountChange;
import com.ry.cds.common.CommonConst;
import com.ry.cds.user.service.IUserAccountService;
import com.ry.cds.utils.JsonUtils;

/**
 * MQ消费者类
 * 
 * @author Administrator
 *
 */
@Component
public class UserAccountChangeReceiver {
	private static final Logger logger = LoggerFactory.getLogger(UserAccountChangeReceiver.class);
	@Autowired
	IUserAccountService userAccountService;
	@Autowired
	@Qualifier("myRabbitTemplete")
	RabbitTemplate myRabbitTemplete;

	@RabbitListener(queues = CommonConst.USERACCOUNTCHANGEQUEUE)
	public void onMessage(Message message, Channel channel) throws Exception {
		String str = null;
		int result = 0;
		try {
			str = new String(message.getBody());
			if (StringUtils.isNotBlank(str)) {
				UserAccountChange data = JsonUtils.JsonToBean(str, UserAccountChange.class);
				result = userAccountService.changeAccount(data);
			}
		} catch (Exception e) {
			result = 99999999;
			String errorQueue = message.getMessageProperties().getConsumerQueue() + "_error";
			channel.queueDeclare(errorQueue, true, false, false, null);
			myRabbitTemplete.convertAndSend(errorQueue, message);
			logger.info("===>MQ服务器发送过来的信息处理异常：{}", message);
		} finally {
			if (result <= 0) {
				channel.basicQos(0, Integer.MAX_VALUE, false);
				channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
			} else {
				channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
			}
		}
	}

}