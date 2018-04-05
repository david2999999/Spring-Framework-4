package com.spring.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.domain.Address;

@Controller
public class ModelAttributeDemoController {
	private static Logger logger = LoggerFactory.getLogger(ModelAttributeDemoController.class);
	
	@RequestMapping(value="/home")
	public String home() {
		logger.info("INSIDE home: " + System.currentTimeMillis());
		return "modelAttributeHome";
	}
	
	// version 2 of the home method
	@RequestMapping(value="/home2")
	public ModelAndView home2() {
		ModelAndView modelAndView  = new ModelAndView();
		modelAndView.setViewName("modelAttributeHome");
		// the "command" will be the object that binds an object to the form
		modelAndView.addObject("command", new Address());
		
		return modelAndView;
	}
	
	// version 3 of the home method
	@RequestMapping(value="/home3")
	public ModelAndView home3() {
		//dont need to create this line modelAndView.setViewName("modelAttributeHome");
		ModelAndView modelAndView  = new ModelAndView("modelAttributeHome");
		modelAndView.addObject("anAddress", new Address());
		
		return modelAndView;
	}
	
	
	// version 4 of the home method. The most succinct way
	@RequestMapping(value="/home4")
	public ModelAndView home4() {
		return new ModelAndView("modelAttributeHome", "anAddress", new Address("Melbourne", "3000"));
	}
	
	// version 5 of the home method. 
	@RequestMapping(value="/home5")
	public String home5(Model model) {
		model.addAttribute("anAddress", new Address("Brisbane", "4000"));
		
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
	
	
	// Test 3: Demonstrating the usage of @ModelAttribute annotation (on a method) to 
	// implicitly add an attribute by returning it and also demonstrating the usage of 
	// 'value' attribute of @ModelAttribute annotation (on a method)
	@ModelAttribute(value = "testdata3")
	public Address modelAttribute() {
		logger.info("INSIDE modelAttributeTest3");
		return new Address("Adelaide", "5000");
	}
	
	// Test 4: Demonstrating the default naming strategy of the @ModelAttribute annotation (on a method)
	// To access this object in the JSP. Use the lower case version of Address (address)
	@ModelAttribute
	public Address modelAttributeTest4() {
		logger.info("INSIDE modelAttributeTest4");
		return new Address("Sydney", "2000");
	}
	
	
	// Test 5:  Testing the @ModelAttribute with 'value' attribute and default binding
	@PostMapping(value="/test5")
	public String modelAttributeTest5(@ModelAttribute(value="anAddress") Address anAddress, ModelMap model) {
		model.addAttribute("testdata5A", anAddress.getCity());
		model.addAttribute("testdata5B", anAddress.getZipCode());
		
		return "modelAttributeTest";
	}
	
	// Test 6: Test to determine nature of how the @ModelAttribute(on method) and @RequestMapping
	// work with no explicit logical view name
	// since view name is not provided. the jsp page that will be loaded is modelAttributeTest.jsp
	@RequestMapping(value="/modelAttributeTest")
	@ModelAttribute("testdata6")
	public Address modelAttributeTest6() {
		return new Address("Canberra", "2600");
	}
	
	
}












