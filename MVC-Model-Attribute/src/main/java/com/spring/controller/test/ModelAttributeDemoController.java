package com.spring.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelAttributeDemoController {
	private static Logger logger = LoggerFactory.getLogger(ModelAttributeDemoController.class);
	
	@RequestMapping(value="/home")
	public String home() {
		logger.info("INSIDE home: " + System.currentTimeMillis());
		return "modelAttributeHome";
	}
	
	// test series to determine the nature of @ModelAttribute notation (on a method)
	// Test 1: Demonstrating the usage of @ModelAttribute annotation (on a method)
	// to add multiple attribute
	@ModelAttribute
	public void modelAttributeTest1(Model model) {
		logger.info("INSIDE modelAttributeTest1: " + System.currentTimeMillis());
		model.addAttribute("testdata1A", "Welcome to the @ModelAttribute Test bed!");
		model.addAttribute("testdata1B", "We will test both usage of @ModelAttribute, "
											+ "on methods and on method arguments");
	}
	
	// Test 2: demonstrating the usage of the 'name' attribute (on method)
	// this will work the same as
	// model.addAttribute("testdata2", "We will conduct a series of test here")
	@ModelAttribute(name="testdata2")
	public String modelAttributeTest2() {
		logger.info("INSIDE modelAttribute 2");
		return "We will conduct a series of test here";
	}
	
	
	
}
