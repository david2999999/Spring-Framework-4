package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.service.GenericWelcomeService;
import com.spring.service.WelcomeService;

@Controller
public class WelcomeController {
	
	@Autowired
	private GenericWelcomeService welcomeService;
	
	@RequestMapping
	public String doWelcome(Model model) {
		
		// retrieving the processed data
		List<String> welcomeMessage = welcomeService.getWelcomeMessage("Dav");
		
		// add data to model
		model.addAttribute("welcomeMessage", welcomeMessage);
		
		// return logical view name. "welcome.jsp"
		return "welcome";
	}
}
