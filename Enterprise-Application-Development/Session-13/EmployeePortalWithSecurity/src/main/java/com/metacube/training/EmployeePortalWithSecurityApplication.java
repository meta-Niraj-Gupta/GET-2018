package com.metacube.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class EmployeePortalWithSecurityApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(EmployeePortalWithSecurityApplication.class, args);
	}
}

