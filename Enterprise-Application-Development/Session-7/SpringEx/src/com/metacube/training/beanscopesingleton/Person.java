package com.metacube.training.beanscopesingleton;

import org.springframework.beans.factory.annotation.Autowired;

public class Person {
	private String name;

	public String getName() {
		return name;
	}
	
	@Autowired(required=false)
	public void setName(String name) {
		this.name = name;
	}
}
