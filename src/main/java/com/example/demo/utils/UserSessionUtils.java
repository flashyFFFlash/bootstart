package com.example.demo.utils;

import com.example.demo.domain.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public final class UserSessionUtils {
	private UserSessionUtils() {
	}

	public static User currentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
			return null;
		}
		return (User) authentication.getDetails();
	}
}
