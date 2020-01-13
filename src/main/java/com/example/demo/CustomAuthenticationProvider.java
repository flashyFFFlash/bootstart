package com.example.demo;

import com.example.demo.domain.User;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private User loadUserByName(String username){
		return getUsers().stream().filter(t -> t.getUsername().equals(username)).findAny().orElse(null);
	}

	private List<User> getUsers(){
		List<User> list = Lists.newArrayList();
		list.add(new User("zhangsan", "123456"));
		list.add(new User("lisi", "123456"));
		list.add(new User("wangwu", "123456"));
		return list;
	}


	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
		User user = loadUserByName(name);
		if(user == null){
			throw  new UsernameNotFoundException("cant find user:"+name);
		}
		if(StringUtils.equals(user.getPassword(), authentication.getCredentials().toString())){
			return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), Lists.newArrayList());
		}
		throw new BadCredentialsException("bad credentials");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
}
