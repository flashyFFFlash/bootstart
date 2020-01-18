package com.example.demo.service;

import com.example.demo.domain.User;

public interface UserService extends BaseService<User>{

	User findUserByUsername(String username);
}
