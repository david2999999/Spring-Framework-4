package com.spring.serviceImpl;

import java.util.Random;

import com.spring.service.RecruitmentService;

public class AgencyRecruitmentServiceImpl implements RecruitmentService{

	@Override
	public String recruitEmployee(String companyName,
			String departmentName, int numberOfrecruits) {

		Random random = new Random();
		String hiringFacts = "\n" + companyName + "'s " + departmentName + " hired " + 
					random.nextInt(numberOfrecruits) + " employees " + 
					" using various hiring agency";
		
		return hiringFacts;
	}

}
