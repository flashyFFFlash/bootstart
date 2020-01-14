package com.example.demo.service;

import com.example.demo.dao.AccountRepository;
import com.example.demo.dao.BaseRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.domain.User;
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
}
