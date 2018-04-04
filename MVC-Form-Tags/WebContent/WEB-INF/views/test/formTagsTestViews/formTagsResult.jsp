<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<spring:url var="formMainCSS" value="/resources/form-main.css" />
	<link href="${formMainCSS}" rel="stylesheet"/>
	<title>Form Tag Result</title>
</head>
<body>
	<h1>Congratulation! you have register your organization</h1>
	<h2>Details Below....</h2>
	<hr/>
	
	<div style="margin-left: 600px; width: auto;">
		<h3>Organization Name: <b>${orgreg.orgName}</b></h3>
		<h3>Country: <b>${orgreg.country}</b></h3>
		<h3>Turnover: 
				<c:forEach var="entry" items="${turnoverlist}">
					<c:if test="${orgreg.turnover eq entry.key}">
						<b>${entry.value}</b>
					</c:if>
				</c:forEach>
		</h3>
		
		<h3>Type: 
			<c:forEach var="entry" items="${typelist}">
				<c:if test="${orgreg.type eq entry.key}">
					<b>${entry.value}</b>
				</c:if>
			</c:forEach>
		</h3>
		
		<h3>Service Length: 
			<c:forEach var="entry" items="${serviceLengthList}">
				<c:if test="${orgreg.serviceLength eq entry.key}">
					<b>${entry.value}</b>
				</c:if>
			</c:forEach>
		</h3>
		
		<h3>Registered Previously: 
			<c:forEach var="entry" items="${registeredPreviouslyList}">
				<c:if test="${orgreg.registeredPreviously eq entry.key}">
					<b>${entry.value}</b>
				</c:if>
			</c:forEach>
		</h3>
		<h3>Like Our Website:
			<c:choose>
				<c:when test="${orgreg.like eq 'yes'}">
					<b>Like</b>
				</c:when>
				<c:otherwise><b>Do not like</b></c:otherwise>
			</c:choose>
		</h3>
	</div>
</body>
</html>