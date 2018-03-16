package com.spring.pnamespace.domain;

public class Organization {

	private String companyName;
	private int yearOfIncorporation;

	private Address address;

	
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setYearOfIncorporation(int yearOfIncorporation) {
		this.yearOfIncorporation = yearOfIncorporation;
	}

	public void setAddress(Address address) {
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


	public int getYearOfincorporation() {
		return yearOfIncorporation;
	}



	
	
	
}
