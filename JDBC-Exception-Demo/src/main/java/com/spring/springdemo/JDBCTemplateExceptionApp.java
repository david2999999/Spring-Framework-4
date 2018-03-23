package com.spring.springdemo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.BadSqlGrammarException;

import com.spring.dao.OrganizationDao;
import com.spring.dao.OrganizationDaoImpl;
import com.spring.domain.Organization;

public class JDBCTemplateExceptionApp {

	public static void main(String[] args) {
		
		// create the application context
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		// create the bean
		OrganizationDao dao = context.getBean("orgDao", OrganizationDaoImpl.class);
		
		
		List<Organization> orgs = null;
		
		try {
			orgs = dao.getAllOrganization();
			
		}catch (BadSqlGrammarException bge) {
			System.out.println("SUB Exception Message: " + bge.getMessage());
			System.out.println("SUB Exception Class: " + bge.getClass());
			
		}catch (Exception e) {
			System.out.println("Exception Message: " + e.getMessage());
			System.out.println("Exception Class: " + e.getClass());
		}
				
		for(Organization organization : orgs) {
			System.out.println(organization);
		}
		
		// close the application context
		((ClassPathXmlApplicationContext)context).close();

	}

}
