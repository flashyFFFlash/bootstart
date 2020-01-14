package com.example.demo.utils;

import java.util.UUID;

public final class UUIDUtil {
	private UUIDUtil() {
	}


	public static String generateUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static void main(String[] args) {
		System.out.println(UUIDUtil.generateUUID());
	}

}
