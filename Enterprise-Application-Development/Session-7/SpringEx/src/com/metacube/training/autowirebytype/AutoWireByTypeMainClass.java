package com.metacube.training.autowirebytype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWireByTypeMainClass {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"auto_wire_by_type.xml");
		TextEditor te = (TextEditor) context.getBean("textEditor");
		te.spellCheck();
	}
}
