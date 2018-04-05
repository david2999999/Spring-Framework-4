package com.spring.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebMvcInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		
		//appContext.setConfigLocation("/WEB-INF/spring/dispatcher-config.xml")
		rootContext.register(WebMvcConfig.class);
		
		
		ServletRegistration.Dynamic registration = 
				servletContext.addServlet("dispatcher", new DispatcherServlet(rootContext));
		
		registration.addMapping("/");
		registration.setLoadOnStartup(1);

	}

}
