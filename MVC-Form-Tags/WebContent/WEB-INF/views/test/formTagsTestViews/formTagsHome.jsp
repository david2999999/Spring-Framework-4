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
					<td><form:label path="country">Country</form:label></td>
					<td>
						<form:select path="country">
							<form:option value="NONE">---SELECT---</form:option>
							<form:option value="Australia">Australia</form:option>
							<form:option value="India">India</form:option>
							<form:option value="Sweden">Sweden</form:option>
							<form:option value="NUnited StatesONE">United States</form:option>
							<form:option value="Egypt">Egypt</form:option>
						</form:select>
					</td>
				</tr>
				
				<tr>
					<td><form:label path="turnover">Turnover</form:label></td>
					<td><form:select path="turnover" items="${turnoverlist}"/></td>
				</tr>
				
				<tr>
					<td><form:label path="type">type</form:label></td>
					<td>
						<form:select path="type" >
							<form:option value="NONE">---SELECT---</form:option>
							<form:options items="${typelist}"/>
						</form:select>
					</td>
				</tr>
				<tr>
					<td><form:label path="serviceLength">Service Length</form:label></td>
					<td><form:select path="serviceLength" items="${serviceLengthList}"/></td>
				</tr>
				
				<tr>
					<td><form:label path="registeredPreviously">Registered Previously</form:label></td>
					<td><form:checkbox path="registeredPreviously" items="${registeredPreviouslyList}"/></td>
				</tr>
				<tr>
					<td><form:label path="like">Like the website?</form:label></td>
					<td><form:checkbox path="like" value="yes"/>Like</td>
				</tr>
				
				<tr>
					<td><form:label path="optionalServices">Optional Services Subscriptions:</form:label></td>
					<td>
						<form:checkbox path="optionalServices" value="emailService"/>${subscriptionList.emailService}
						<form:checkbox path="optionalServices" value="promotionalService"/>${subscriptionList.promotionalService}
						<form:checkbox path="optionalServices" value="newsLetterService"/>${subscriptionList.newsLetterService}
					</td>
				</tr>
				

				<tr>
					<td align="center"><input type="submit" value="Submit"/></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>