package com.spring.iocDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IOCApp1 {

	public static void main(String[] args) {
		
		// create the application context (container)
		ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
		
		// create the bean
		// "myorg" is the bean id from the beans.xml
		Organizaton organizaton = (Organizaton) context.getBean("myorg");
		
		// invoke the bean method
		organizaton.corporateSlogan();
		
		// close the application context (container)
		((FileSystemXmlApplicationContext) context).close();
	}

}
