package com.spring.serviceImpl;

import java.util.Random;

import com.spring.service.RecruitmentService;

public class ReferralRecruitmentServiceImpl implements RecruitmentService {

	@Override
	public String recruitEmployee(String companyName, String departmentName, int numberOfrecruits) {
		Random random = new Random();
		String hiringFacts = "\n" + companyName + "'s " + departmentName + " hired " + 
						random.nextInt(numberOfrecruits) + " employees " + 
						"which were referred to the company by employees";
		
		return hiringFacts;
	}
	
	

}
