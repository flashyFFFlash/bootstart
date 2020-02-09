package com.example.demo.security;

import com.example.demo.domain.User;
import com.example.demo.enums.Status;
import com.example.demo.service.UserService;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class NormalAuthenticationProvider implements AuthenticationProvider {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
		User user = this.userService.findUserByUsername(name);
		if (user == null) {
			throw new UsernameNotFoundException("cant find user:" + name);
		}
		if (Status.DISABLE.equals(user.getStatus())) {
			throw new DisabledException("user " + name + " is disabled");
		}
		if (StringUtils.equals(user.getPassword(), authentication.getCredentials().toString())) {
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), Lists.newArrayList());
			usernamePasswordAuthenticationToken.setDetails(user);
			return usernamePasswordAuthenticationToken;
		}
		throw new BadCredentialsException("bad credentials");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
}
