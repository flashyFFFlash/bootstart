package com.example.demo.service;

import com.example.demo.dao.BaseRepository;
import com.example.demo.dao.RoleRepository;
import com.example.demo.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public BaseRepository<Role> repository() {
		return this.repository();
	}
}
