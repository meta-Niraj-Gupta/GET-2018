package com.metacube.training.constructorinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorInjectionMainClass {
	public static void main(String[] agrs){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		TextEditor textEditor = (TextEditor) context.getBean("textEditor");
		textEditor.spellingCheck();
	}
}
