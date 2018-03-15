package com.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.Organizaton;

public class BeanScopeApp {

	public static void main(String[] args) {
		
		// create the application context (container)
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		// create the bean
		// "myorg" is the bean id from the beans.xml
		Organizaton organizaton = context.getBean("myorg", Organizaton.class);
		Organizaton organizaton2 =  context.getBean("myorg", Organizaton.class);
		
		organizaton2.setPostalCode("123123");
		
		// print organization details
		System.out.println(organizaton);
		
		// print organization details
		System.out.println(organizaton);
		
		if (organizaton == organizaton2) {
			System.out.println("Singleton test: org and org2 point to the same instance");
		}else {
			System.out.println("org and org2 are separate instances.");
		}
				
		// close the application context (container)
		context.close();
	}

}
