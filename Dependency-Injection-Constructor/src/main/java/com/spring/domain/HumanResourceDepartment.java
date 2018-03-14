package com.spring.domain;

import com.spring.service.RecruitmentService;

public class HumanResourceDepartment implements Department {

	private String departmentName;
	private RecruitmentService recruitmentService;
	private Organizaton organization;
	
	
	
	public HumanResourceDepartment(RecruitmentService recruitmentService, Organizaton organization) {
		this.recruitmentService = recruitmentService;
		this.organization = organization;
	}

	@Override
	public String hiringStatus(int numberOfRecruitments) {
		String hiringFacts = recruitmentService.recruitEmployee(organization.getCompanyName()
				, departmentName, numberOfRecruitments);
		
		return hiringFacts;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	
	
	
	

}
