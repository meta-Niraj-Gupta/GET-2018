package com.metacube.training.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@ComponentScan("com.metacube.training")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.authenticationProvider(customAuthenticationProvider);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/admin/*")
				.access("hasRole('ADMIN')")
				.antMatchers("/employee/*")
				.access("hasRole('USER')")
				.and()
				.formLogin()
				.loginPage("/login")
				.usernameParameter("username")
				.passwordParameter("password")
				.failureUrl("/login?error")
				.loginProcessingUrl("/login")
				.successHandler(new AuthenticationSuccessHandler() {
					@Override
					public void onAuthenticationSuccess(
							HttpServletRequest request,
							HttpServletResponse response, Authentication auth)
							throws IOException, ServletException {
						if (auth.getAuthorities().toString().contains("USER")) {
							response.sendRedirect("employee/profile");
						} else if (auth.getAuthorities().toString()
								.contains("ADMIN")) {
							response.sendRedirect("admin/dashboard");
						}
					}
				}).and().logout().logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout");
		http.csrf().disable();
	}
}