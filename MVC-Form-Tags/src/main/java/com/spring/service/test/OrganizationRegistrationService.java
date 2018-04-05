package com.spring.service.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrganizationRegistrationService {

	@Value("#{serviceLengthOptions}")
	private Map<String, String> serviceLengthList;
	
	public Map<String, String> populateTurnover(){
		Map<String, String> turnover = new LinkedHashMap<String, String>();
		turnover.put("none", "---Select---");
		turnover.put("1000", "Less than $1000");
		turnover.put("10000", "Greater than $1000 but less than $10000");
		turnover.put("100000", "Greater than $10000 but less than $100000");
		
		return turnover;
	}
	
	public Map<String, String> populateType(){
		Map<String, String> types = new LinkedHashMap<String, String>();
		types.put("none", "---Select---");
		types.put("gov", "Government");
		types.put("semigov", "Semi Government");
		types.put("private", "Private");
		
		return types;
	}
	
	public Map<String, String> populateServiceLengths(){
		return new TreeMap<String, String>(serviceLengthList);
	}
	
	// This will be used for checkbox
	public Map<String, String> populateRegisteredPreviously(){
		Map<String, String> registeredPreviously = new LinkedHashMap<String, String>();
		registeredPreviously.put("true", "Yes");
		registeredPreviously.put("false", "No");
		
		return registeredPreviously;
	}
	
	public Map<String, String> populateOptionalServices(){
		Map<String, String> optionalServices = new LinkedHashMap<String, String>();
		optionalServices.put("emailService", "Mailing List");
		optionalServices.put("promotionalService", "Promotional Emails");
		optionalServices.put("newsLetterService", "Weekly News Service");
		
		return optionalServices;
	}
	
	public Map<String, String> populatePremiumServices(){
		Map<String, String> premiumServices = new LinkedHashMap<String, String>();
		premiumServices.put("directoryService", "Directory");
		premiumServices.put("revenueService", "Revenue Reports");
		premiumServices.put("revenueAnalyticsService", "Revenue Analytics");
		
		return premiumServices;
	}
	
}












