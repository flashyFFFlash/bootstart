package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;


	public void createUser(){
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setUsername("haha");
		this.userRepository.save(user);
	}

}
