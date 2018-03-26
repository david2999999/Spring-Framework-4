package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService implements GenericWelcomeService {

	public List<String> getWelcomeMessage(String name){
		List<String> myWelcomeMessage = new ArrayList();
		
		// add data to the list
		myWelcomeMessage.add("Hello! ");
		myWelcomeMessage.add(name);
		myWelcomeMessage.add(", welcome to the spring course. Inside service layer");
		
		return myWelcomeMessage;
	}
}
