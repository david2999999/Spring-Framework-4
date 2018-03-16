package com.spring.pnamespace;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.pnamespace.domain.Organization;

public class PnamespaceApp {

	public static void main(String[] args) {
		
		// create the application context (container)
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		// create the bean
		// "myorg" is the bean id from the beans.xml
		Organization organizaton = (Organization) context.getBean("myorg");
		
		// print organization details
		System.out.println(organizaton);
		
		// close the application context (container)
		((ClassPathXmlApplicationContext)context).close();
	}

}
