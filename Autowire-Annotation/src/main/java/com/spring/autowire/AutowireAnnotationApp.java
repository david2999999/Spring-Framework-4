package com.spring.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.Organizaton;
import com.spring.domain.promotion.TradeFair;

public class AutowireAnnotationApp {

	public static void main(String[] args) {
		
		// create the application context (container)
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		TradeFair tradeFair = context.getBean("tradeFair", TradeFair.class);
		System.out.println(tradeFair.specialPromotionalString());
		
		// close the application context (container)
		context.close();
	}

}
