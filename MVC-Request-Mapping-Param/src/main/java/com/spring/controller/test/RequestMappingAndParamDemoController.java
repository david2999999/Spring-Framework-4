package com.spring.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "/requestMappingAndParamDemo")
@Controller
public class RequestMappingAndParamDemoController {

	//private static Logger logger = LoggerFactory.getLogger(RequestMappingAndParamDemoController.class);

	@RequestMapping(value = "/home")
	public String home() {
		return "requestMappingAndParamHome";
	}

	// test 1: Testing @RequestParam without explicit attributes
	@RequestMapping(value = "/test1")
	public String requestMappingAndParamTest1(@RequestParam("orgName") String orgName, Model model) {
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test1");
		return "requestMappingAndParamResults";
	}

	// test 2: Testing @RequestMapping 'method' attribute
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String requestMappingAndParamTest2(@RequestParam("orgName") String orgName, Model model) {
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test2");
		return "requestMappingAndParamResults";
	}

	// test 3: Testing @RequestMapping fal back feature
	@RequestMapping(value = "*", method = RequestMethod.GET)
	// @RequestMapping(value="*", method= {RequestMethod.GET, RequestMethod.POST})
	public String requestMappingAndParamTest3() {
		return "fallback";
	}

	// test 4: Testing @RequestParam 'defaultValue' attribute
	@RequestMapping(value = "/test4")
	// @RequestMapping(value="*", method= {RequestMethod.GET, RequestMethod.POST})
	public String requestMappingAndParamTest4(
			@RequestParam(value = "orgName", defaultValue = "Anonymous Organization") String orgName, Model model) {
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test4");
		return "requestMappingAndParamResults";
	}

	// test 5: Testing @RequestParam without 'name' or 'value' attribute
	@RequestMapping(value = "/test5", method = RequestMethod.GET)
	public String requestMappingAndParamTest5(@RequestParam String orgName, Model model) {
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test5");
		return "requestMappingAndParamResults";
	}

//	// test 6: subtest1 - Testing @RequestMapping
//	@RequestMapping(value = "/test6")
//	public String requestMappingAndParamTest6SubTest1(@RequestParam String orgName, Model model) {
//		model.addAttribute("orgname", orgName);
//		model.addAttribute("testserial", "test6-subtest1");
//		return "requestMappingAndParamResults2";
//	}
	
	// test 6: Subtest1 : Testing removal of @requestMapping ambiguity with the same base URI but
	// with a different parameter
	@RequestMapping(value = "/test6", params="orgName")
	public String requestMappingAndParamTest6SubTest1(@RequestParam String orgName, Model model) {
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test6-subtest1");
		return "requestMappingAndParamResults2";
	}

	// test 6: Subest2 : Testing removal of @requestMapping ambiguity with the same base URI but
	// with a different parameter
	@RequestMapping(value = "/test6", params="empcount")
	public String requestMappingAndParamTest6SubTest2(@RequestParam String empcount, Model model) {
		model.addAttribute("orgname", empcount);
		model.addAttribute("testserial", "test6-subtest2");
		return "requestMappingAndParamResults2";
	}
	
//	// test 6: Subest2 - Testing @RequestMapping
//	@RequestMapping(value = "/test6")
//	public String requestMappingAndParamTest6SubTest2(@RequestParam String empcount, Model model) {
//		model.addAttribute("orgname", empcount);
//		model.addAttribute("testserial", "test6-subtest2");
//		return "requestMappingAndParamResults2";
//	}
}
