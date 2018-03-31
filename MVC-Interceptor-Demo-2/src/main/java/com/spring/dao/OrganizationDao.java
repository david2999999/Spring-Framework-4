package com.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import com.spring.domain.Organization;

public interface OrganizationDao {
	
	// set the data-source that will be 
	// required to create a connection to the database
	public void setDataSource(DataSource ds);
	
	// create a record in the organization table
	public boolean create(Organization org);
	
	// retrieve a single organization
	public Organization getOrganization(Integer id);
	
	// retrieve all organizations from the table
	public List<Organization> getAllOrganization();
	
	// delete a specific organization from the table
	public boolean delete(Organization org);
	
	// update a specific organization from the table
	public boolean update(Organization org);
	
	public void cleanup();
}
