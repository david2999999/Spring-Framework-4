package com.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.domain.test.OrganizationRegistration;
import com.spring.service.test.OrganizationRegistrationService;

@Controller
@RequestMapping("/formTagsDemo")
public class FormTagsController {
	
	@Autowired
	private OrganizationRegistrationService organizationRegistrationService;
	
	
	@RequestMapping("/home")
	public ModelAndView home(Model model) {
		return new ModelAndView("test/formTagsTestViews/formTagsHome", 
				"orgRegistration", new OrganizationRegistration());
	}
	
	@RequestMapping(value="/registerOrg", method=RequestMethod.POST)
	public String organizationRegistration(@ModelAttribute OrganizationRegistration organizationRegistration,
											Model model) {
		model.addAttribute("orgreg", organizationRegistration);
		
		return "test/formTagsTestViews/formTagsResult";
	}
	
	@ModelAttribute
	public void populateFormObjectWithData(Model model) {
		Map<String, Object> map = model.asMap();
		map.put("turnoverlist", organizationRegistrationService.populateTurnover());
		map.put("typelist", organizationRegistrationService.populateType());
		map.put("serviceLengthList", organizationRegistrationService.populateServiceLengths());
		map.put("registeredPreviouslyList", organizationRegistrationService.populateRegisteredPreviously());
		map.put("subscriptionList", organizationRegistrationService.populateOptionalServices());
	}
	
}
