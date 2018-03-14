package com.spring.service.demo;

import java.util.ArrayList;
import java.util.List;

public class WelcomeService {

	public List<String> getWelcomeMessage(String name){
		List<String> myWelcomeMessage = new ArrayList();
		
		// add data to the list
		myWelcomeMessage.add("Hello! ");
		myWelcomeMessage.add(name);
		myWelcomeMessage.add(", welcome to the spring course. Inside service layer");
		
		return myWelcomeMessage;
	}
}
