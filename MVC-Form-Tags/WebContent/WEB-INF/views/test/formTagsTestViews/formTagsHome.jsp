<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
	<spring:url var="formMainCSS" value="/resources/form-main.css" />
	<link href="${formMainCSS}" rel="stylesheet"/>
	<title>Test Bed</title>
</head>
<body>
	<div align="center">
		<h1>Welcome to the Form Tags Test Bed</h1><hr/>
		<h3>Register your Organization with us!</h3>
		<form:form action="registerOrg" modelAttribute="orgRegistration">
			<table>
				<tr>
					<td><form:label path="orgName">Name of Organization</form:label></td>
					<td><form:input path="orgName" placeholder="Enter Organization Name"/></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="Submit"/></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>