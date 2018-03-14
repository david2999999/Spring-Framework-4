package com.spring.iocDemo;

public class Organizaton {

	private String companyName;
	private int yearOfIncorporation;

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
