package com.spring.controller.test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
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
	
	//private static Logger logger = LoggerFactory.getLogger(SessionRequestAttributeController.class);
	
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
								HttpServletRequest request,
								@SessionAttribute(name="sessionStartTime") LocalDateTime startTime,
								@RequestAttribute(name="currentTime") LocalDateTime clockTime,
								Model model) {
		
		VisitorData visitorDataFromSession = (VisitorData) session.getAttribute("visitordata");
		visitorService.registerVisitor(visitorDataFromSession, currentVisitor);
		VisitorCount visitorCount = (VisitorCount) session.getAttribute("visitorcount");
		visitorService.updateCount(visitorCount);
		
		Long currentSessionDuration = visitorService.computeDuration(startTime);
		
		if (visitorCount.getCount() == 5) {
			// Mark the current handler's session processing as complete, allowing for cleanup of session attributes.
			sessionStatus.setComplete();
			// Invalidates this session then unbinds any objects bound to it.
			//session.invalidate();
		}
		
//		model.addAttribute("timeHeading", visitorService.describeCurrentTime(clockTime));
//		model.addAttribute("durationHeading", visitorService.describeCurrentDuration(currentSessionDuration));
		
		// another way similiar to model.addAttribute
		Map<String, Object> modelMap = model.asMap();
		modelMap.put("timeHeading", visitorService.describeCurrentTime(clockTime));
		modelMap.put("durationHeading", visitorService.describeCurrentDuration(currentSessionDuration));
		
		// debug code
//		logger.info(visitorDataFromSession.toString());
//		if (request.getMethod().equalsIgnoreCase("POST")) {
//			logger.info("This is a POST Request");
//		}else {
//			logger.info("This is a GET Request");
//		}
		
		return "test/sessionRequestAttributeViews/sessionRequestAttributeResult";
	}
	
	
	
}
