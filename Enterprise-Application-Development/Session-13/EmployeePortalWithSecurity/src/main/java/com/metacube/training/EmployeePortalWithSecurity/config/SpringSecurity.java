package com.metacube.training.EmployeePortalWithSecurity.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin")
				.roles("ADMIN");
		auth.inMemoryAuthentication().withUser("user").password("{noop}user")
				.roles("USER");
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/admin/**")
				.access("hasRole('ROLE_ADMIN')")
				.antMatchers("/employee/**")
				.access("hasRole('ROLE_USER')")
				.anyRequest()
				.authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.permitAll()
				.successHandler(new AuthenticationSuccessHandler() {
					@Override
					public void onAuthenticationSuccess(
							HttpServletRequest request,
							HttpServletResponse response,
							Authentication authentication) throws IOException,
							ServletException {
						if (authentication.getAuthorities().toString()
								.contains("ROLE_USER")) {
							response.sendRedirect("employee/profile");
						} else {
							response.sendRedirect("admin/dashboard");
						}
					}
				}).failureUrl("/login?error").and().logout()
				.logoutSuccessUrl("/login?logout");
		http.csrf().disable();
	}
}
