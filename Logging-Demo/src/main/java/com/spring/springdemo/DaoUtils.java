package com.spring.springdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.dao.OrganizationDao;
import com.spring.domain.Organization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class DaoUtils {
	
	private static Logger LOGGER = LoggerFactory.getLogger("Logging Tester");
	public final String createOperation = "CREATE";
	public final String readOperation = "READ";
	public final String updateOperation = "UPDATE";
	public final String deleteOperation = "DELETE";
	public final String cleanUpOperation = "TRUNCATE";
	
	public void printOrganizations(List<Organization> organizations, String operation) {
		LOGGER.info("\n+++++PRINTING ORGANIZATIONS AFTER " + operation + " operation +++++++++++");
		
		for(Organization organization : organizations) {
			LOGGER.info(organization.toString());
		}
	}
	
	public void printOrganization(Organization org, String operation) {
		LOGGER.info("\n++++++Printing organization after invoking " + operation + " +++++++++++++\n" + org);
	}
	
	public void printSuccessFailure(String operation, boolean param) {
		if (param) {
			LOGGER.info("\nOperation " + operation + " successful");
		}else {
			LOGGER.info("\nOperation " + operation + " unsuccessful");
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
		
		LOGGER.info("Created " + createCount + " organization");
	}
		
	public void printOrganizationCount(List<Organization> orgs, String operation) {
		LOGGER.info("\n+++++Currently we have " + orgs.size() + " organizations after " + operation + " operations +++++++++");
		
	}
	
}



















