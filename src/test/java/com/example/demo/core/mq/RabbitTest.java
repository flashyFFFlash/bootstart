package com.example.demo.core.mq;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@Import(RabbitMQConfig.class)
@SpringBootTest
public class RabbitTest {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private Producer producer;

	//Direct
	@Test
	public void sendDirectMsg() {
		producer.sendDirectMsg(RabbitMQConfig.queueName, "i need money");
	}

	//Topic
	@Test
	public void sendTopicMsg() {
		producer.sendExchangeMsg(RabbitMQConfig.topicExchangeName, "routingKey1", "hello world 111");
	}

	//Fanout
	@Test
	public void sendFanoutMsg() {
		producer.sendExchangeMsg(RabbitMQConfig.fanoutExchange, "routingKey2",
				"i really need money");
	}

	//Headers
	@Test
	public void sendHeadersMsg() {
		Map<String, Object> map = new HashMap<>();
		map.put("First", "A");
		producer.sendHeadersMsg(RabbitMQConfig.headersExchange, "hello word", map);
	}

}
