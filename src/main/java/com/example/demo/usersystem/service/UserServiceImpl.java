package com.example.demo.usersystem.service;

import com.example.demo.usersystem.dao.AccountRepository;
import com.example.demo.usersystem.dao.BaseRepository;
import com.example.demo.usersystem.dao.UserRepository;
import com.example.demo.usersystem.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public BaseRepository<User> repository() {
		return this.userRepository;
	}

	@Override
	public User findUserByUsername(String username) {
		return this.userRepository.findUserByUsername(username);
	}
}
