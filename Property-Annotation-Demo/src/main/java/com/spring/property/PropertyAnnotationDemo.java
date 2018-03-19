package com.spring.property;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.domain.Organization;

public class PropertyAnnotationDemo {

	public static void main(String[] args) {
		
		// create the application context (container)
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PropertyConfig.class);
		
		Organization organization = context.getBean("myorg", Organization.class);
		System.out.println(organization);
		System.out.println("Slogan: " + organization.corporateSlogan());
		
		// close the context
		context.close();
	}

}
