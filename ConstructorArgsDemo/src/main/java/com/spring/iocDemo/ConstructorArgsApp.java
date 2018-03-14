package com.spring.iocDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorArgsApp {

	public static void main(String[] args) {
		
		// create the application context (container)
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		// create the bean
		// "myorg" is the bean id from the beans.xml
		Organizaton organizaton = (Organizaton) context.getBean("myorg");
		
		// invoke the bean method
		organizaton.corporateSlogan();
		
		// print organization details
		System.out.println(organizaton);
		
		// close the application context (container)
		((ClassPathXmlApplicationContext)context).close();
	}

}
