package com.spring.springdemo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.dao.OrganizationDao;
import com.spring.dao.OrganizationDaoImpl;
import com.spring.domain.Organization;

public class JdbcTemplateApp2 {

	public static void main(String[] args) {
		
		// create the application context
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		// create the bean
		OrganizationDao dao = context.getBean("orgDao", OrganizationDaoImpl.class);

		// creating seed data
		DaoUtils.createSeedData(dao);
		
		// List Organizations
		List<Organization> organizations = dao.getAllOrganization();
		DaoUtils.printOrganizations(organizations, DaoUtils.readOperation);
		
		// create a new organization record
		Organization organization = new Organization("General Electric", 1923, "9219", 5776, "Imagination at work");
		boolean isCreated = dao.create(organization);
		DaoUtils.printSuccessFailure(DaoUtils.createOperation, isCreated);
		DaoUtils.printOrganizations(dao.getAllOrganization(), DaoUtils.readOperation);
		
		// get a single organizatin
		Organization organization2 = dao.getOrganization(1);
		DaoUtils.printOrganization(organization2, "getOrganization");
		
		// updating slogan for an organization
		Organization organization3 = dao.getOrganization(2);
		organization3.setSlogan("We Build AWESOME driving machines");
		boolean isUpdated = dao.update(organization3);
		DaoUtils.printSuccessFailure(DaoUtils.updateOperation, isUpdated);
		DaoUtils.printOrganization(dao.getOrganization(2), DaoUtils.updateOperation);
		
		// delete an organization
		boolean isDeleted = dao.delete(dao.getOrganization(3));
		DaoUtils.printSuccessFailure(DaoUtils.deleteOperation, isDeleted);
		DaoUtils.printOrganizations(dao.getAllOrganization(), DaoUtils.deleteOperation);
		
		// clean up
		dao.cleanup();
		DaoUtils.printOrganizationCount(dao.getAllOrganization(), DaoUtils.cleanUpOperation);
		
		// close the application context
		((ClassPathXmlApplicationContext)context).close();

	}

}
