package com.spring.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.spring.service.BusinessService;

@Component("myorg")
public class Organization {

	@Value("${nameOfCompany}")
	private String companyName;
	
	@Value("${startUpYear}")
	private int yearOfIncorporation;
	
	@Value("${postalCode}")
	private String postalCode;
	
	@Value("${empCount:22222}")
	private int employeeCount;
	
	@Value("${slogan: We build spring software}")
	private String slogan;
	
	private String missionStatement;
	
	@Autowired
	private Environment env;
	
	private BusinessService businessService;

	public Organization() {
		System.out.println("Default Constructor Called");
	}
	
	public Organization(String companyName, int yearOfincorporation) {
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfincorporation;
		System.out.println("Organization: Constructor called.");
	}
	
	
	public String corporateSlogan() {
		missionStatement = env.getProperty("statement");
		
		return missionStatement + " and also " + slogan;
	}
	
	
//	public void initialize() {
//		System.out.println("Organization: initialize method called");
//	}
//	
//	public void destroy() {
//		System.out.println("Organization: destroy method called");
//	}
	

	public void postConstruct() {
		System.out.println("organization: POSTCONTRUCT called");
	}
	
	public void preDestroy() {
		System.out.println("organization: PREDESTROY called");
	}


	public String corporateService() {
		return businessService.offerService(companyName);
	}
	
	@Override
	public String toString() {
		return "Organization " + companyName + 
				" has been incorporation for " + yearOfIncorporation + " years."
				+ " Employee count of " + employeeCount + " and postal code of " + postalCode;
	}
	
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getYearOfIncorporation() {
		return yearOfIncorporation;
	}

	public void setYearOfIncorporation(int yearOfIncorporation) {
		this.yearOfIncorporation = yearOfIncorporation;
	}

	public String getPostalCode() {
		return postalCode;

	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		System.out.println("Set postal code called");
	}

	public int getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
		System.out.println("Set employeecount called");
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
		System.out.println("Set slogan called");
	}

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
		System.out.println("Set businessService called");
	}

	
	
	
}
