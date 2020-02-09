package com.example.demo.core.rest;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.StreamUtils;

@Slf4j
public class JSONMessageConverter extends AbstractGenericHttpMessageConverter<Object> {


	public JSONMessageConverter() {
		setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
	}

	@Override
	public boolean canWrite(Type type, Class<?> clazz, MediaType mediaType) {
		if (!canWrite(mediaType)) {
			return false;
		}
		if (clazz == JSONObject.class || clazz == JSONArray.class) {
			return true;
		}
		log.debug("cant write of class {}", clazz.getName());
		return false;
	}

	@Override
	protected void writeInternal(Object jsonObject, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
		HttpHeaders headers = outputMessage.getHeaders();
		Charset charset = getContentTypeCharset(headers.getContentType());
		StreamUtils.copy(jsonObject.toString(), charset, outputMessage.getBody());
	}

	private Charset getContentTypeCharset(@Nullable MediaType contentType) {
		if (contentType != null && contentType.getCharset() != null) {
			return contentType.getCharset();
		} else if (contentType != null && contentType.isCompatibleWith(MediaType.APPLICATION_JSON)) {
			// Matching to AbstractJackson2HttpMessageConverter#DEFAULT_CHARSET
			return StandardCharsets.UTF_8;
		} else {
			Charset charset = getDefaultCharset();
			Assert.state(charset != null, "No default charset");
			return charset;
		}
	}

	@Override
	protected JSONObject readInternal(Class<? extends Object> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
		return null;
	}

	@Override
	public JSONObject read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
		return null;
	}
}
