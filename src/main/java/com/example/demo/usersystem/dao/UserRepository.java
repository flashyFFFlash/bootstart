package com.example.demo.usersystem.dao;

import com.example.demo.usersystem.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User> {
	User findUserByUsername(String username);
}
