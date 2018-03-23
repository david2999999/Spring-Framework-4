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
		
		// clean up
		dao.cleanup();
		DaoUtils.printOrganizationCount(dao.getAllOrganization(), DaoUtils.cleanUpOperation);
		
		// close the application context
		((ClassPathXmlApplicationContext)context).close();

	}

}
