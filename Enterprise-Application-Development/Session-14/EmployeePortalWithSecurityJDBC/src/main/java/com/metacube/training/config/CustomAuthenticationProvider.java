package com.metacube.training.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.metacube.training.model.Employee;
import com.metacube.training.model.UserRoles;
import com.metacube.training.service.EmployeeService;
import com.metacube.training.service.UserRolesService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	@Autowired
	private EmployeeService empService;
	@Autowired
	private UserRolesService userRolesService;

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		String username = authentication.getName();
		Object credentials = authentication.getCredentials();
		if (!(credentials instanceof String)) {
			return null;
		}
		// String password = credentials.toString();
		Employee employee = empService.getEmployeeByEmail(username);
		if (employee == null) {
			throw new UsernameNotFoundException("User not found");
		}

		List<UserRoles> user = userRolesService.allUsers(username);
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		for (UserRoles roles : user) {
			grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"
					+ roles.getRole()));
		}
		Authentication auth = new UsernamePasswordAuthenticationToken(
				employee.getEmailId(), employee.getPassword(),
				grantedAuthorities);
		return auth;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}