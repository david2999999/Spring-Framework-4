package com.spring.beanFactory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactoryApp {

	public static void main(String[] args) {
		
		// create the application context (container)
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		// create the bean
		Organization organizaton = context.getBean("myorg", Organization.class);
		
		Organization organizaton2 = context.getBean("myorg2", Organization.class);

		// print organization details
		System.out.println(organizaton);
		
		System.out.println(organizaton2);
		
		// close the application context (container)
		context.close();
	}

}
