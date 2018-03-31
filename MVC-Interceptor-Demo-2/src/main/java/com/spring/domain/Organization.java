package com.spring.domain;

public class Organization {

	private int id;
	private String companyName;
	private int yearOfIncoporation;
	private String postalCode;
	private int employeeCount;
	private String slogan;
	
	public Organization() {
		// TODO Auto-generated constructor stub
	}
	
	public Organization(String companyName, int yearOfIncoporation, String postalCode, int employeeCount,
			String slogan) {
		this.companyName = companyName;
		this.yearOfIncoporation = yearOfIncoporation;
		this.postalCode = postalCode;
		this.employeeCount = employeeCount;
		this.slogan = slogan;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getYearOfIncoporation() {
		return yearOfIncoporation;
	}
	public void setYearOfIncoporation(int yearOfIncoporation) {
		this.yearOfIncoporation = yearOfIncoporation;
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
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	@Override
	public String toString() {
		return "Organization [id=" + id + ", companyName=" + companyName + ", yearOfIncoporation=" + yearOfIncoporation
				+ ", postalCode=" + postalCode + ", employeeCount=" + employeeCount + ", slogan=" + slogan + "]";
	}
	
	
}
