<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
	<spring:url var="testMainCSS" value="/resources/test-main.css" />
	<link href="${testMainCSS}" rel="stylesheet"/>
	<%-- <link href="<c:url value="/resources/test-main.css"/>" rel="stylesheet"/> --%>
	<title>Test Bed</title>
</head>
<body>
	<div align="center">
		<h1>@SessionAttribute Test Bed</h1><hr/>
		<form:form action="visitor" modelAttribute="visitorstats">
			<tr>
				<td><form:label path="currentVisitorName">Name</form:label></td>
				<td><form:input path="currentVisitorName"/></td>
			</tr>
			<tr>
				<td><form:label path="currentVisitorEmail">Email</form:label></td>
				<td><form:input path="currentVisitorEmail"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"/></td>
			</tr>
		</form:form>
	</div>
</body>
</html>