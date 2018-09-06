package com.metacube.training.setterinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterInjectionMainClass {
	public static void main(String[] agrs) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		TextEditor textEditor = (TextEditor) context.getBean("textEditor1");
		textEditor.spellingCheck();
	}
}
