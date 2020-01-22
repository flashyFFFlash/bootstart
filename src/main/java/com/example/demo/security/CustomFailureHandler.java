package com.example.demo.security;

import com.example.demo.core.rest.ReturnCode;
import com.example.demo.core.rest.ServiceResult;
import com.example.demo.utils.JsonUtils;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class CustomFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		ServiceResult serviceResult = new ServiceResult(ReturnCode.FAILURE);
		String str = JsonUtils.toJson(serviceResult);
		response.getWriter().write(Objects.requireNonNull(str));
	}
}
