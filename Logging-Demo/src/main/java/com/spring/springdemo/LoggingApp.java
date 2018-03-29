package com.spring.springdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.spring.dao.OrganizationDao;
import com.spring.dao.OrganizationDaoImpl;
import com.spring.domain.Organization;


@Component
public class LoggingApp {
	
	@Autowired
	private OrganizationDao dao;
	
	@Autowired
	private DaoUtils daoUtils;

	public void actionMethod() {

		dao.cleanup();
		
		// creating seed data
		daoUtils.createSeedData(dao);
		
		// List Organizations
		List<Organization> organizations = dao.getAllOrganization();
		daoUtils.printOrganizations(organizations, daoUtils.readOperation);
		
		// create a new organization record
		Organization organization = new Organization("General Electric", 1923, "9219", 5776, "Imagination at work");
		boolean isCreated = dao.create(organization);
		daoUtils.printSuccessFailure(daoUtils.createOperation, isCreated);
		daoUtils.printOrganizations(dao.getAllOrganization(), daoUtils.readOperation);
		
		// get a single organizatin
		Organization organization2 = dao.getOrganization(1);
		daoUtils.printOrganization(organization2, "getOrganization");
		
		// updating slogan for an organization
		Organization organization3 = dao.getOrganization(2);
		organization3.setSlogan("We Build AWESOME driving machines");
		boolean isUpdated = dao.update(organization3);
		daoUtils.printSuccessFailure(daoUtils.updateOperation, isUpdated);
		daoUtils.printOrganization(dao.getOrganization(2), daoUtils.updateOperation);
		
		// delete an organization
		boolean isDeleted = dao.delete(dao.getOrganization(3));
		daoUtils.printSuccessFailure(daoUtils.deleteOperation, isDeleted);
		daoUtils.printOrganizations(dao.getAllOrganization(), daoUtils.deleteOperation);
		
		// clean up

		daoUtils.printOrganizationCount(dao.getAllOrganization(), daoUtils.cleanUpOperation);
	}
	
	public static void main(String[] args) {
		// create the application context
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-cp.xml");
		LoggingApp mainApp = context.getBean(LoggingApp.class);
		
		mainApp.actionMethod();
		
		// close the application context
		((ClassPathXmlApplicationContext)context).close();

	}

}
