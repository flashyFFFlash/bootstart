package com.example.demo.core.rest;

public final class ReturnCode {

	private ReturnCode() {
	}

	/**
	 * 成功.
	 */
	public static final int SUCCESS = 1;
	/**
	 * 失败.
	 */
	public static final int FAILURE = 9;
	/**
	 * 验证错误.
	 */
	public static final int VALIDATE_ERROR = 2;
	/**
	 * 未找到.
	 */
	public static final int NOT_FOUND = 3;

}