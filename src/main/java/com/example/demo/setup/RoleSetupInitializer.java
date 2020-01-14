package com.example.demo.setup;

import com.example.demo.domain.Role;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleSetupInitializer extends Initializer {

	@Autowired
	private RoleService roleService;

	@Override
	public void initialize() {
		initRole(Role.ADMIN_ROLE_ID, "ADMIN", "超级管理员", "拥有所有权限");
	}

	private void initRole(String id, String code, String name, String desc) {
		Role adminRole = this.roleService.findById(id);
		if (adminRole == null) {
			adminRole = new Role();
			adminRole.setCode(code);
			adminRole.setName(name);
			adminRole.setDesc(desc);
			this.roleService.create(adminRole);
		}
	}
}