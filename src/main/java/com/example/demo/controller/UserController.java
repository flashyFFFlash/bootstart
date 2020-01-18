package com.example.demo.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public Object createUser() {
		JSONArray array = new JSONArray();


		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "zhangsan");

		array.put(jsonObject);

//		Map<String, Object> map = Maps.newHashMap();
//		map.put("name", "name1");
		return array;
	}
}
