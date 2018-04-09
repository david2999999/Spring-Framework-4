package com.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
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
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public boolean create(Organization org) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org);
		
		String sqlQuery = "INSERT INTO organization (company_name, year_of_incoporation , postal_code, employee_count, slogan)" + 
						"VALUE(:companyName,:yearOfIncoporation,:postalCode,:employeeCount,:slogan)";

		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	public Organization getOrganization(Integer id) {
		
		SqlParameterSource params = new MapSqlParameterSource("ID", id); 
		
		String sqlQuery = "SELECT id, company_name, year_of_incoporation , postal_code, employee_count, slogan " + 
							" FROM organization WHERE id = :ID";
	
		Organization organization = namedParameterJdbcTemplate.queryForObject(sqlQuery, params, new OrganizationRowMapper());
		
		return organization;
	}

	public List<Organization> getAllOrganization() {
		String sqlQuery = "SELECT * FROM organization";
		List<Organization> orgList = namedParameterJdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
		
		return orgList;
	}

	public boolean delete(Organization org) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org);
		
		String sqlQuery = "DELETE from organization where id = :id";
		
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	public boolean update(Organization org) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org);
		
		String sqlQuery = "UPDATE organization SET slogan = :slogan WHERE id = :id";
		
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	public void cleanup() {
		String sqlQuery = "TRUNCATE TABLE organization";
		namedParameterJdbcTemplate.getJdbcOperations().execute(sqlQuery);

	}

}
