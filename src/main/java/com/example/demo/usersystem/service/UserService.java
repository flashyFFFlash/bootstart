package com.example.demo.usersystem.service;

import com.example.demo.usersystem.domain.User;

public interface UserService extends BaseService<User> {

	User findUserByUsername(String username);
}
