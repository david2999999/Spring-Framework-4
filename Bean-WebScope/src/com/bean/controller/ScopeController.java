package com.bean.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.service.RandomizerRequestScope;
import com.bean.service.RandomizerSessionScope;

@Controller
public class ScopeController {

	@Autowired
	RandomizerRequestScope randomizerRequestScope;
	
	@Autowired
	RandomizerSessionScope randomizerSessionScope;
	
	@RequestMapping("/")
	public void getRandom(HttpServletResponse response) throws Exception{
		response.getWriter().write("---REQUEST SCOPE--- <br>");
		response.getWriter().write("Old number: " + randomizerRequestScope.getRandomNumber() + "<br>");
		randomizerRequestScope.generateRandomNumber();
		response.getWriter().write("New Number: " + randomizerRequestScope.getRandomNumber() + "<br>");
		response.getWriter().write("Object reference: " + randomizerRequestScope + "<br>");
		
		
		response.getWriter().write("---SESSION SCOPE--- <br>");
		response.getWriter().write("Old number: " + randomizerSessionScope.getRandomNumber() + "<br>");
		randomizerSessionScope.generateRandomNumber();
		response.getWriter().write("New Number: " + randomizerSessionScope.getRandomNumber() + "<br>");
		response.getWriter().write("Object reference: " + randomizerSessionScope + "<br>");
	}
}
