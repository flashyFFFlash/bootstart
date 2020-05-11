package com.example.demo.usersystem.service;

import com.example.demo.usersystem.dao.BaseRepository;
import com.example.demo.usersystem.dao.RoleRepository;
import com.example.demo.usersystem.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public BaseRepository<Role> repository() {
		return this.roleRepository;
	}
}
