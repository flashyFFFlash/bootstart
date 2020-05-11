package com.example.demo.setup;

import com.example.demo.usersystem.domain.Role;
import com.example.demo.usersystem.domain.User;
import com.example.demo.usersystem.service.RoleService;
import com.example.demo.usersystem.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SetupInitializer extends Initializer {

	private final RoleService roleService;
	private final UserService userService;

	public SetupInitializer(RoleService roleService, UserService userService) {
		this.roleService = roleService;
		this.userService = userService;
	}


	@Override
	public void initialize() {
		initRole(Role.ADMIN_ROLE_ID, "ADMIN", "超级管理员", "拥有所有权限");

		initUser("admin", "boot@2019");
	}

	private void initRole(String id, String code, String name, String desc) {
		Role adminRole = this.roleService.findById(id);
		if (adminRole == null) {
			adminRole = new Role();
			adminRole.setCode(code);
			adminRole.setName(name);
			adminRole.setDesc(desc);
			this.roleService.create(adminRole);
			log.info("role create successfully:【{}, {}】", code, name);
		}
	}

	private void initUser(String username, String password) {
		User user = this.userService.findUserByUsername(username);
		if(user == null){
			user = new User();
			user.setUsername(username);
			user.setPassword(password);
			this.userService.create(user);
		}
	}
}
