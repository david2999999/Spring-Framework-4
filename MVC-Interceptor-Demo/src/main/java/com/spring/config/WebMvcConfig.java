package com.spring.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.spring.interceptor.HeaderInterceptor;

@Configuration
@ComponentScan("com.spring")
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

	@Bean
	public DataSource DataSource() {
		final JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		dataSourceLookup.setResourceRef(true);
		
		// this database configuration can be found in 
		DataSource dataSource = dataSourceLookup.getDataSource("jdbc/springdb");
		
		return dataSource;
	}


	@Bean
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
		RequestMappingHandlerMapping requestMappingHandlerMapping = new RequestMappingHandlerMapping();
		//Whether to use suffix pattern match (".*") when matching patterns to requests. 
		// If enabled a method mapped to "/users" also matches to "/users.*".
		requestMappingHandlerMapping.setUseSuffixPatternMatch(true);
		
		//Whether to match to URLs irrespective of the presence of a trailing slash. 
		//If enabled a method mapped to "/users" also matches to "/users/".
		requestMappingHandlerMapping.setUseTrailingSlashMatch(true);
		
		return requestMappingHandlerMapping;
	}
	
	@Bean
	public UrlBasedViewResolver urlBasedViewResolver() {
		 UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		 resolver.setPrefix("/WEB-INF/views/");
		 resolver.setSuffix(".jsp");
		 resolver.setViewClass(JstlView.class);
		 
		 return resolver;
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
		// <mvc:view-controller path="/" view-name="home"/>
	}


	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HeaderInterceptor());
	}
	
	
	
}
