package com.example.demo;

import com.example.demo.core.rest.JSONMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@EnableCaching
@SpringBootApplication
public class DemoApplication {

	@Bean
	public JSONMessageConverter getJSONMessageConverter() {
		return new JSONMessageConverter();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
