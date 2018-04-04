package com.spring.interceptor;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Service
public class VisitorInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// currentTime is refreshed after every request
		request.setAttribute("currentTime", LocalDateTime.now());
		
		// request.getSession(true) will return current session. 
		// If current session does not exist, then it will create a new session.
		HttpSession session = request.getSession(true);
		
		// make sure the session start time is only generated once
		if (session.getAttribute("sessionStartTime") == null) {
			session.setAttribute("sessionStartTime", LocalDateTime.now());
		}
		
		return true;
		
	}

	
}
