package com.metacube.training.EmployeePortalWithSecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("user").password("{noop}user").roles("USER");
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin/login").permitAll()
				.anyRequest().authenticated().and().formLogin()
				.loginPage("/admin/login")
				.defaultSuccessUrl("/admin/dashboard")
				.failureUrl("/admin/login?error").and().logout()
				.logoutSuccessUrl("/admin/login").deleteCookies("JSESSIONID")
				.invalidateHttpSession(true);
		http.csrf().disable();
	}
}
