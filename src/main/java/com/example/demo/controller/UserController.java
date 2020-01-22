package com.example.demo.controller;

import com.example.demo.core.rest.ReturnCode;
import com.example.demo.core.rest.ServiceResult;
import com.example.demo.domain.User;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping(value = "/create")
	public Object createUser(User user) {
		if (StringUtils.isBlank(user.getUsername())) {
			return new ServiceResult(ReturnCode.VALIDATE_ERROR, "用户名不能为空");
		}
		this.userService.create(user);
		return new ServiceResult(ReturnCode.SUCCESS);
	}

	@PostMapping(value = "/update")
	public Object updateUser(@PathVariable String id, UserDTO userDTO) {
		User user = this.userService.findById(id);
		if (user == null) {
			return new ServiceResult(ReturnCode.NOT_FOUND);
		}
		BeanUtils.copyProperties(userDTO, user);
		this.userService.update(user);
		return new ServiceResult(ReturnCode.SUCCESS);
	}

	@DeleteMapping(value = "/delete")
	public Object deleteUser(@PathVariable String id) {
		User user = this.userService.findById(id);
		if (user == null) {
			return new ServiceResult(ReturnCode.NOT_FOUND);
		}
		this.userService.delete(user);
		return new ServiceResult(ReturnCode.SUCCESS);
	}

	@PostMapping
	public Object updatePassword(@PathVariable String id, @RequestParam String oldPwd, @RequestParam String newPwd) {
		User user = this.userService.findById(id);
		if (user == null) {
			return new ServiceResult(ReturnCode.NOT_FOUND);
		}
		if (!StringUtils.equals(oldPwd, user.getPassword())) {
			return new ServiceResult(ReturnCode.FAILURE, "密码错误！");
		}
		user.setPassword(newPwd);
		this.userService.update(user);
		return new ServiceResult(ReturnCode.SUCCESS);
	}
}
