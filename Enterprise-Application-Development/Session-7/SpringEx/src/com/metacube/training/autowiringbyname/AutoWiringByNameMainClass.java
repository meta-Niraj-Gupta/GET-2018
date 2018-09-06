package com.metacube.training.autowiringbyname;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWiringByNameMainClass {
	public static void main(String[] args) {
	      ApplicationContext context = new ClassPathXmlApplicationContext("auto_wire_by_name.xml");
	      TextEditor textEditor = (TextEditor) context.getBean("textEditor");
	      textEditor.spellCheck();
	   }
}
