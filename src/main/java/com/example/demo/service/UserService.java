package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * .
 *
 * @author gxj
 * @since 19-6-17
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;


	public void createUser(){
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setName("hahha");
		this.userRepository.save(user);
	}

}
