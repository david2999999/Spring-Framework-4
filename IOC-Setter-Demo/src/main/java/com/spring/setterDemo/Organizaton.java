package com.spring.setterDemo;

public class Organizaton {

	private String companyName;
	private int yearOfIncorporation;
	
	private String postalCode;
	private int employeeCount;

	public Organizaton() {
		// TODO Auto-generated constructor stub
	}
	
	public Organizaton(String companyName, int yearOfincorporation) {
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfincorporation;
	}
	
	public void corporateSlogan() {
		String slogan = "We Build Spring Applications";
		System.out.println(slogan);
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

	
	
	
}
