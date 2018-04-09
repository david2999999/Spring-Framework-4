package com.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.domain.test.OrganizationRepresentative;

@Controller
@RequestMapping("/formValidation")
public class FormValidationController {
	
	private static Logger logger = LoggerFactory.getLogger(FormValidationController.class);
	
	@RequestMapping("/home")
	public ModelAndView home() {
		return new ModelAndView("test/formValidationTestViews/formValidationHome", 
								"orgrep", new OrganizationRepresentative());
	}
	
	@RequestMapping(value="/registerOrgRep", method=RequestMethod.POST)
	public String organizationRepresentativeRegistration(
			@Valid @ModelAttribute("orgrep") OrganizationRepresentative orgRepresentative,
			BindingResult result, Model model) {
		
		// debug code
		if(result.hasErrors()) {
			model.addAttribute("formerrors", result.getAllErrors());
			List<FieldError> ferrList = result.getFieldErrors();
			for(FieldError fError : ferrList) {
				logger.info("field error: " + fError.getDefaultMessage());
			}
			
			List<ObjectError> gerrFeList = result.getGlobalErrors();
			for(ObjectError gerr: gerrFeList) {
				logger.info("global errors: " + gerr.getDefaultMessage());
			}
			
			return "test/formValidationTestViews/formValidationHome";
		}else{
			return "test/formValidationTestViews/formValidationResult";
		}
		
	}
	
	
}








