package com.example.demo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

@Slf4j
public final class JsonUtils {
	private JsonUtils() {
	}

	private static ObjectMapper objectMapper = new ObjectMapper();

	public static String toJson(Object object) {
		try {
			return objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			log.error(e.getLocalizedMessage(), e);
		}
		return null;
	}

	public static <T> T toObject(String json, Class<T> valueType) {
		Assert.hasText(json, "字符串不能为空");
		Assert.notNull(valueType, "目标类型不能为空");
		try {
			return objectMapper.readValue(json, valueType);
		} catch (IOException e) {
			log.error(e.getLocalizedMessage(), e);
		}
		return null;
	}

}
