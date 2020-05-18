package com.example.demo.core.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RabbitListener(queues = RabbitMQConfig.queueName)
public class Consumer {

	@RabbitHandler
	public void handle(Object msg) {
		log.info("consume message :{}", msg);
	}

}
