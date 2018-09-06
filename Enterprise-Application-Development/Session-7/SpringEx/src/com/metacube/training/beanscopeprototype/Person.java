package com.metacube.training.beanscopeprototype;

import org.springframework.beans.factory.annotation.Autowired;

public class Person {
	
	@Autowired(required=false)
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
