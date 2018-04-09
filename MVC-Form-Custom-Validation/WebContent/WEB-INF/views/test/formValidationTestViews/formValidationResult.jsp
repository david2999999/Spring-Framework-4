<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<spring:url value="/resources/test-main.css" var="testMainCSS" />
	<link href="${testMainCSS}" rel="stylesheet" />
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Validation Test Results</title>
</head>
<body>
	<h1 class="ch1">Congratulations. You are now a registered representative of your organization</h1>
	<h2 class="ch2">Details are below</h2><hr/>
	
	<div style="text-align: center">
		<h1>Name: <b class="cb">${orgrep.firstName}</b></h1>
	</div>
	
	<div style="text-align: center">
		<h1>Surname: <b class="cb">${orgrep.lastName}</b></h1>
	</div>
	
	<div style="text-align: center">
		<h1>Age: <b class="cb">${orgrep.age}</b></h1>
	</div>
	
	<div style="text-align: center">
		<h1>Age: <b class="cb">${orgrep.zipCode}</b></h1>
	</div>
	
	<div style="text-align: center">
		<h1>Email: <b class="cb">${orgrep.email}</b></h1>
	</div>
	<hr/>
	<div align="center">
		<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
		<a href="${contextPath}/formValidation/home" style="font-size: 17px">
			Click here to go back to the home page
		</a>
	</div>
</body>
</html>



