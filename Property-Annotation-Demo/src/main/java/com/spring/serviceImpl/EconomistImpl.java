package com.spring.serviceImpl;

import java.util.Random;

import com.spring.service.BusinessService;

public class EconomistImpl implements BusinessService {

	@Override
	public String offerService(String companyName) {
		Random random = new Random();
		
		String service = "\nAs an organization, " + companyName + 
				" provides an outstanding Ecommerce platform.\n" + 
				"The annual revenue exceeds " + random.nextInt(revenue) + " dollars";
		
		return service;
	}

}
