package com.spring.domain;

import com.spring.service.BusinessService;

public class Organizaton {

	private String companyName;
	private int yearOfIncorporation;
	
	private String postalCode;
	private int employeeCount;
	
	private String slogan;
	private BusinessService businessService;

	public Organizaton() {
		System.out.println("Default Constructor Called");
	}
	
	public Organizaton(String companyName, int yearOfincorporation) {
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfincorporation;
		System.out.println("Constructor called.");
	}
	
	
	public void initialize() {
		System.out.println("Organization: initialize method called");
	}
	
	public void destroy() {
		System.out.println("Organization: destroy method called");
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

	public void setSlogan(String slogan) {
		this.slogan = slogan;
		System.out.println("Set slogan called");
	}

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
		System.out.println("Set businessService called");
	}

	
	
	
}
