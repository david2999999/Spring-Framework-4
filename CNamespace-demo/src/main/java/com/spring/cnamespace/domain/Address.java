package com.spring.cnamespace.domain;

public class Address {
	
	private String street;
	private String city;
	private String zipCode;
	
	
	public Address(String street, String city, String zipCode) {
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
	}
	
	@Override
	public String toString() {
		return "Address: " + street + ", city: " + city + ", zipCode: " + zipCode;
	}
	
}
