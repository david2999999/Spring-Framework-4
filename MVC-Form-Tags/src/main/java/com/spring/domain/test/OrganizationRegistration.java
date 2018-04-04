package com.spring.domain.test;

public class OrganizationRegistration {

	// This field is used for input field
	private String orgName;
	
	// These fields are used for select field
	private String country;
	private String turnover;
	private String type;
	private String serviceLength;
	
	// These fields are used for checkbox field
	private boolean registeredPreviously = true;
	private String like;
	
	public String getLike() {
		return like;
	}

	public void setLike(String like) {
		this.like = like;
	}

	public boolean isRegisteredPreviously() {
		return registeredPreviously;
	}

	public void setRegisteredPreviously(boolean registeredPreviously) {
		this.registeredPreviously = registeredPreviously;
	}

	public String getServiceLength() {
		return serviceLength;
	}

	public void setServiceLength(String serviceLength) {
		this.serviceLength = serviceLength;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTurnover() {
		return turnover;
	}

	public void setTurnover(String turnover) {
		this.turnover = turnover;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	
}
