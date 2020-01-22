package com.example.demo.controller;

import com.example.demo.core.rest.ReturnCode;
import com.example.demo.core.rest.ServiceResult;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
public class SystemController {

	@RequestMapping("/csrf")
	public Object csrf(HttpServletRequest request) {
		CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
		if (csrfToken == null) {
			return new ServiceResult(ReturnCode.NOT_FOUND, "未找到csrfToken");
		}
		return new ServiceResult(ReturnCode.SUCCESS, null, csrfToken.getToken());
	}
}
