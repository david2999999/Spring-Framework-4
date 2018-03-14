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
		// TODO Auto-generated constructor stub
	}
	
	public Organizaton(String companyName, int yearOfincorporation) {
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfincorporation;
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
	}

	public int getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}

	
	
	
}
