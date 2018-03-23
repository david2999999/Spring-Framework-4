package com.spring.springdemo;

import java.util.ArrayList;
import java.util.List;

import com.spring.dao.OrganizationDao;
import com.spring.domain.Organization;

public class DaoUtils {

	public final String createOperation = "CREATE";
	public final String readOperation = "READ";
	public final String updateOperation = "UPDATE";
	public final String deleteOperation = "DELETE";
	public final String cleanUpOperation = "TRUNCATE";
	
	public void printOrganizations(List<Organization> organizations, String operation) {
		System.out.println("\n+++++PRINTING ORGANIZATIONS AFTER " + operation + " operation +++++++++++");
		
		for(Organization organization : organizations) {
			System.out.println(organization);
		}
	}
	
	public void printOrganization(Organization org, String operation) {
		System.out.println("\n++++++Printing organization after invoking " + operation + " +++++++++++++\n" + org);
	}
	
	public void printSuccessFailure(String operation, boolean param) {
		if (param) {
			System.out.println("\nOperation " + operation + " successful");
		}else {
			System.out.println("\nOperation " + operation + " unsuccessful");
		}
	}
	
	public void createSeedData(OrganizationDao dao) {
		Organization org1 = new Organization("Google", 1929, "12312", 12315, "Work Hard, have Fun");
		Organization org2 = new Organization("BWM", 1939, "12312", 1522, "Hello bmw here");
		Organization org3 = new Organization("Facebook", 1934, "12312", 5221, "Hello, fb here");
		
		List<Organization> organizations = new ArrayList<Organization>();
		organizations.add(org1); organizations.add(org2); organizations.add(org3);
		int createCount = 0;
		for(Organization organization: organizations) {
			boolean isCreated = dao.create(organization);
			if (isCreated) {
				createCount++;
			}
		}
		
		System.out.println("Created " + createCount + " organization");
	}
		
	public void printOrganizationCount(List<Organization> orgs, String operation) {
		System.out.println("\n+++++Currently we have " + orgs.size() + " organizations after " + operation + " operations +++++++++");
		
	}
	
}



















