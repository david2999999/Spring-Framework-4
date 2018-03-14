package com.spring.InversionOfControlChallenge;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IOCAppChallenge2 {

	public static void main(String[] args) {
		// get the context or container
		FileSystemXmlApplicationContext context = 
				new FileSystemXmlApplicationContext("beans-challenge.xml");
		
		// retrieve the bean
		City city = (City)context.getBean("city");
		
		// call the method from the bean or object
		city.cityName();
		
		// close the context
		context.close();
		

	}

}
