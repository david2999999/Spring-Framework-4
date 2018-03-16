package com.spring.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.Organizaton;

public class AutowireAnnotationApp {

	public static void main(String[] args) {
		
		// create the application context (container)
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-cp.xml");
		
//		// create the bean
//		// "myorg" is the bean id from the beans.xml
//		Organizaton organizaton = (Organizaton) context.getBean("myorg");
//		
//		// invoke the bean method
//		System.out.println(organizaton.corporateSlogan()); 
//		
//		// print organization details
//		System.out.println(organizaton);
//		
//		System.out.println(organizaton.corporateService());
		
		// close the application context (container)
		((ClassPathXmlApplicationContext)context).close();
	}

}
