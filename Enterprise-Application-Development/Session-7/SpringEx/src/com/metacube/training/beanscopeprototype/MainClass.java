package com.metacube.training.beanscopeprototype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("prototype.xml");
		Person person = (Person) context.getBean("person");
		person.setName("Niraj");
		System.out.println(person.getName());
		
		Person person1 = (Person) context.getBean("person");
		System.out.println(person1.getName());
	}
}
