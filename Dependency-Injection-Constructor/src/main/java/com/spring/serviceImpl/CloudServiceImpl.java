package com.spring.serviceImpl;

import java.util.Random;

import com.spring.service.BusinessService;

public class CloudServiceImpl implements BusinessService {

	@Override
	public String offerService(String companyName) {
		Random random = new Random();
		String service = "\nAs an organization, " + companyName + 
				" offers world class cloud service computing infrastructure\n " + 
				"The annual income exceeds " + random.nextInt(revenue) + " dollars";
		
		return service;
	}
	
	

}
