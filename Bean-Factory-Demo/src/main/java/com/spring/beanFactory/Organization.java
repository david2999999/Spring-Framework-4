package com.spring.beanFactory;

public class Organization {

	private String companyName;
	private int yearOfIncorporation;

	public Organization() {
		// TODO Auto-generated constructor stub
	}
	
	public Organization(String companyName, int yearOfincorporation) {
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfincorporation;
	}
	
	public void corporateSlogan() {
		String slogan = "We Build Spring Applications";
		System.out.println(slogan);
	}

	
	public static Organization createInstance(String companyName, int yearOfIncorporation) {
		String slogan = "Invoking the static factory method.....";
		System.out.println(slogan);
		
		return new Organization(companyName, yearOfIncorporation);
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "Organization " + companyName + 
				" has been incorporation for " + yearOfIncorporation + " years";
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getYearOfincorporation() {
		return yearOfIncorporation;
	}

	public void setYearOfincorporation(int yearOfincorporation) {
		this.yearOfIncorporation = yearOfincorporation;
	}

	
	
	
}
