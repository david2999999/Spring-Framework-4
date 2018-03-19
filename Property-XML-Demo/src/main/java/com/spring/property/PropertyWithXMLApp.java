package com.spring.property;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.Organization;
import com.spring.domain.promotion.TradeFair;

public class PropertyWithXMLApp {

	public static void main(String[] args) {
		
		// create the application context (container)
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		Organization organizaton = context.getBean("myorg", Organization.class);
		System.out.println(organizaton);
		
		// close the application context (container)
		context.close();
	}

}
