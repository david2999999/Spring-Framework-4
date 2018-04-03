package com.spring.controller.test;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.spring.domain.test.Visitor;
import com.spring.domain.test.VisitorCount;
import com.spring.domain.test.VisitorData;
import com.spring.domain.test.VisitorService;

@Controller
@SessionAttributes(names={"visitordata", "visitorcount"})
@RequestMapping("/visitorRegister")
public class SessionRequestAttributeController {
		
	@Autowired
	public VisitorService visitorService;
	
	private static Logger logger = LoggerFactory.getLogger(SessionRequestAttributeController.class);
	
	@RequestMapping("/home")
	public ModelAndView home() {
		return new ModelAndView(
				"test/sessionRequestAttributeViews/sessionRequestAttributeHome", 
				"visitorstats", new VisitorData());
	}
	
	@ModelAttribute("visitordata")
	public VisitorData addVisitorData() {
		List<Visitor> visitors = new ArrayList<>();
		VisitorData visitorData = new VisitorData(null, null, visitors);
		return visitorData;
	}
	
	@ModelAttribute("visitorcount")
	public VisitorCount countVisitors() {
		return new VisitorCount(0);
	}
	
	@RequestMapping(value="/visitor", method=RequestMethod.POST)
	public String getVisitors(@ModelAttribute("visitorstats") VisitorData currentVisitor,
								HttpSession session,
								SessionStatus sessionStatus,
								HttpServletRequest request) {
		VisitorData visitorDataFromSession = (VisitorData) session.getAttribute("visitordata");
		visitorService.registerVisitor(visitorDataFromSession, currentVisitor);
		
		VisitorCount visitorCount = (VisitorCount) session.getAttribute("visitorcount");
		visitorService.updateCount(visitorCount);
		
		if (visitorCount.getCount() == 5) {
			sessionStatus.setComplete();
		}
		
		// debug code
		logger.info(visitorDataFromSession.toString());
		if (request.getMethod().equalsIgnoreCase("POST")) {
			logger.info("This is a POST Request");
		}else {
			logger.info("This is a GET Request");
		}
		
		return "test/sessionRequestAttributeViews/sessionRequestAttributeResult";
	}
	
	
	
}
