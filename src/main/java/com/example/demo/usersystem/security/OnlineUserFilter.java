package com.example.demo.usersystem.security;

import com.example.demo.usersystem.domain.User;
import com.example.demo.utils.UserSessionUtils;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

@Service
public class OnlineUserFilter extends OncePerRequestFilter implements ApplicationListener<HttpSessionDestroyedEvent> {

	@Autowired
	private UserSessionManager userSessionManager;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			User user = UserSessionUtils.currentUser();
			if (user != null) {
				this.userSessionManager.getOnlineUser(session.getId(), user);
			}
		}
		filterChain.doFilter(request, response);
	}

	@Override
	public void onApplicationEvent(HttpSessionDestroyedEvent event) {
		HttpSession session = event.getSession();
		this.userSessionManager.removeOnlineUser(session.getId());
	}
}
