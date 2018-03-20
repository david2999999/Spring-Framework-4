package com.spring.springdemo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.dao.OrganizationDao;
import com.spring.dao.OrganizationDaoImpl;
import com.spring.domain.Organization;

public class JdbcTemplateApp1 {

	public static void main(String[] args) {
		
		// create the application context
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		// create the bean
		OrganizationDao dao = context.getBean("orgDao", OrganizationDaoImpl.class);
		List<Organization> orgs = dao.getAllOrganization();
		
		for(Organization organization : orgs) {
			System.out.println(organization);
		}
		
		// close the application context
		((ClassPathXmlApplicationContext)context).close();

	}

}
