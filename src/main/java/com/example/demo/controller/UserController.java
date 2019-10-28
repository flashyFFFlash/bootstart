package com.example.demo.controller;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * .
 *
 * @author gxj
 * @since 19-6-17
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public Object createUser() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "zhangsan");

//		Map<String, Object> map = Maps.newHashMap();
//		map.put("name", "name1");
		return jsonObject;
	}
}
