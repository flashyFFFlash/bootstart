package com.example.demo.core.rest;

import lombok.Data;

@Data
public class ServiceResult {

	private int code;
	private String description;
	private Object result;

	public ServiceResult(int code) {
		this.code = code;
	}

	public ServiceResult(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public ServiceResult(int code, String description, Object result) {
		this.code = code;
		this.description = description;
		this.result = result;
	}

	public ServiceResult(int code, Object result) {
		this.code = code;
		this.result = result;
	}

}