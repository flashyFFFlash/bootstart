package com.example.demo.security;

import com.example.demo.core.rest.ReturnCode;
import com.example.demo.core.rest.ServiceResult;
import com.example.demo.utils.JsonUtils;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		ServiceResult serviceResult = new ServiceResult(ReturnCode.SUCCESS);
		String str = JsonUtils.toJson(serviceResult);
		response.getWriter().write(Objects.requireNonNull(str));
	}
}
