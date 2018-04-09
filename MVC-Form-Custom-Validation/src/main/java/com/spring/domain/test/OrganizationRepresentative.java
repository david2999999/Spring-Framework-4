package com.spring.domain.test;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.spring.validation.test.AgeConstraint;

public class OrganizationRepresentative {

	@NotBlank(message="* First Name: cannot be blank!")
	private String firstName;

	@NotEmpty(message="* Surname: cannot be empty")
	@Size(min=3, max=10, message="* Surname: min 3 characters, max 10 characters")
	private String lastName;
	
	@AgeConstraint
	private Integer age;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
