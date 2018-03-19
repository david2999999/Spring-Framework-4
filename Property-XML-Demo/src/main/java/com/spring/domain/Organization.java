package com.spring.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.spring.service.BusinessService;

public class Organization {

	private String companyName;
	private int yearOfIncorporation;
	private int employeeCount;
	private String slogan;
	private BusinessService businessService;
	
	@Value("${org.postalCode}")
	private String postalCode;
	

	public Organization() {
		System.out.println("Default Constructor Called");
	}
	
	public Organization(String companyName, int yearOfincorporation) {
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfincorporation;
		System.out.println("Organization: Constructor called.");
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
	
	public String corporateSlogan() {
		return slogan;
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

	@Autowired
	public void setSlogan(@Value("${org.slogan}") String slogan) {
		this.slogan = slogan;
		System.out.println("Set slogan called");
	}

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
		System.out.println("Set businessService called");
	}

	
	
	
}
