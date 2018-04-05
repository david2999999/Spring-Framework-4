package com.spring.domain.test;

import org.hibernate.validator.constraints.NotBlank;

public class OrganizationRepresentative {

	@NotBlank(message="* First Name: cannot be blank!")
	private String firstName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
}
