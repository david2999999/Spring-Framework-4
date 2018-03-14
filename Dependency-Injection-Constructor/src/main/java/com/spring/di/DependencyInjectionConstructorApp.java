package com.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.HumanResourceDepartment;
import com.spring.domain.Organizaton;

public class DependencyInjectionConstructorApp {

	public static void main(String[] args) {
		
		// create the application context (container)
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		// create the bean
		// "myorg" is the bean id from the beans.xml
		Organizaton organizaton = (Organizaton) context.getBean("myorg");
		
		// invoke the bean method
		System.out.println(organizaton.corporateSlogan()); 
		
		// print organization details
		HumanResourceDepartment humanResourceDepartment = context.getBean("humanResourceDept", HumanResourceDepartment.class);
		
		System.out.println(humanResourceDepartment.hiringStatus(5500));
		
		// close the application context (container)
		context.close();
	}

}
