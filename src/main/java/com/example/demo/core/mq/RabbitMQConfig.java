package com.example.demo.core.mq;

import java.util.HashMap;
import java.util.Map;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	public static final String topicExchangeName = "topic-exchange";
	public static final String fanoutExchange = "fanout-exchange";
	public static final String headersExchange = "headers-exchange";

	public static final String queueName = "queue-name";

	//声明队列
	@Bean
	public Queue queue() {
		//Queue(String name, boolean durable, boolean exclusive, boolean autoDelete)
		return new Queue(queueName, true, false, true);
	}

	//声明Topic交换机
	@Bean
	TopicExchange topicExchange() {
		return new TopicExchange(topicExchangeName);
	}

	//将队列与Topic交换机进行绑定，并指定路由键
	@Bean
	Binding topicBinding(Queue queue, TopicExchange topicExchange) {
		return BindingBuilder.bind(queue).to(topicExchange).with("routingKey1");
	}

	//声明fanout交换机
	@Bean
	FanoutExchange fanoutExchange() {
		return new FanoutExchange(fanoutExchange);
	}

	//将队列与fanout交换机进行绑定
	@Bean
	Binding fanoutBinding(Queue queue, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(queue).to(fanoutExchange);
	}

	//声明Headers交换机
	@Bean
	HeadersExchange headersExchange() {
		return new HeadersExchange(headersExchange);
	}

	//将队列与headers交换机进行绑定
	@Bean
	Binding headersBinding(Queue queue, HeadersExchange headersExchange) {
		Map<String, Object> map = new HashMap<>();
		map.put("First", "A");
		map.put("Fourth", "D");
		//whereAny表示部分匹配，whereAll表示全部匹配
//        return BindingBuilder.bind(queue).to(headersExchange).whereAll(map).match();
		return BindingBuilder.bind(queue).to(headersExchange).whereAny(map).match();
	}
}
