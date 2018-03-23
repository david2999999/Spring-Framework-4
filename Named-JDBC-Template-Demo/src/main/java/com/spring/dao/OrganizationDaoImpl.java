package com.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.spring.daoImpl.OrganizationRowMapper;
import com.spring.domain.Organization;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public boolean create(Organization org) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org);
		
		String sqlQuery = "INSERT INTO organization (company_name, year_of_incoporation , postal_code, employee_count, slogan)" + 
						"VALUE(:companyName,:yearOfIncoporation,:postalCode,:employeeCount,:slogan)";
//		Object[] args = new Object[] {org.getCompanyName(), org.getYearOfIncoporation(), org.getPostalCode(),
//										org.getEmployeeCount(), org.getSlogan()};
//		
//		return jdbcTemplate.update(sqlQuery, args) == 1;
		
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	public Organization getOrganization(Integer id) {
		String sqlQuery = "SELECT id, company_name, year_of_incoporation , postal_code, employee_count, slogan " + 
							" FROM organization WHERE id = ?";
		Object[] args = new Object[] {id};
		
		Organization organization = jdbcTemplate.queryForObject(sqlQuery, args, new OrganizationRowMapper());
		
		return organization;
	}

	public List<Organization> getAllOrganization() {
		String sqlQuery = "SELECT * FROM organization";
		List<Organization> orgList = jdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
		
		return orgList;
	}

	public boolean delete(Organization org) {
		String sqlQuery = "DELETE from organization where id = ?";
		Object[] args = new Object[] {org.getId()};
		
		return jdbcTemplate.update(sqlQuery, args) == 1;
	}

	public boolean update(Organization org) {
		String sqlQuery = "UPDATE organization SET slogan = ? WHERE id = ?";
		Object[] args = new Object[] {org.getSlogan(), org.getId()};
		
		return jdbcTemplate.update(sqlQuery, args) == 1;
	}

	public void cleanup() {
		String sqlQuery = "TRUNCATE TABLE organization";
		jdbcTemplate.execute(sqlQuery);

	}

}
