package com.spring.cnamespace.domain;

public class Organizaton {

	private String companyName;
	private int yearOfIncorporation;

	private Address address;

	
	public Organizaton(String companyName, int yearOfIncorporation, Address address) {
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfIncorporation;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Organization " + companyName + 
				" has been incorporation for " + yearOfIncorporation + " years. " 
				+ "Address " + address;
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
