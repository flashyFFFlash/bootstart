package com.example.demo.security;

import com.example.demo.domain.Role;
import java.util.Arrays;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter() {
		UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter = new UsernamePasswordAuthenticationFilter();
		usernamePasswordAuthenticationFilter.setAuthenticationManager(this.authenticationManager());
		usernamePasswordAuthenticationFilter.setAuthenticationSuccessHandler(new CustomSuccessHandler());
		usernamePasswordAuthenticationFilter.setAuthenticationFailureHandler(new CustomFailureHandler());
		return usernamePasswordAuthenticationFilter;
	}

	@Bean
	public AuthenticationManager authenticationManager() {
		List<AuthenticationProvider> list = Arrays.asList(normalAuthenticationProvider());
		return new ProviderManager(list);
	}

	@Bean
	public NormalAuthenticationProvider normalAuthenticationProvider() {
		return new NormalAuthenticationProvider();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilter(this.usernamePasswordAuthenticationFilter());
		http.authorizeRequests()
				.antMatchers("/login").permitAll()
				.antMatchers("/user").hasRole(Role.ADMIN_ROLE_ID)
				.antMatchers("/**").authenticated()
				.and()
				.csrf()
				.ignoringAntMatchers("/login");
	}
}
