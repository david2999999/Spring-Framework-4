package com.spring.beanFactory;

public class OrganizationFactory {
	
	public Organization getInstance(String companyName, int yearOfIncoporation) {
		System.out.println("Invoking instance factory method");
		
		return new Organization(companyName, yearOfIncoporation);
	}
}
