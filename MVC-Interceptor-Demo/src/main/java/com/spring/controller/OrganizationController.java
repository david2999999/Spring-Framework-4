package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.domain.Organization;
import com.spring.service.OrganizationService;

@Controller
public class OrganizationController {

	@Autowired
	private OrganizationService organizationService;
	
	@RequestMapping("/listOrgs")
	public String listOrganizations(Model model) {
		List<Organization> organizations = organizationService.getOrgList();
		model.addAttribute("orgList", organizations);
		
		return "listOrganization2";
	}
	
	@RequestMapping("/location")
	public String addLocation() {
		return "location";
	}
}
