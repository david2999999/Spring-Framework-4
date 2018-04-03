<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
	<spring:url var="testMainCSS" value="/resources/test-main.css" />
	<link href="${testMainCSS}" rel="stylesheet"/>
	<title>Test Results</title>
</head>
<body>
	<div align="center">
		<h1>@SessionAttribute Test Results</h1><hr/>
		<h3>
			No of page visits in this session:
			<c:out value="${visitorcount.count}"/>
		</h3>
		<h3>List of Visitors in this site</h3>
		
		<ul>
			<c:forEach var="visitor" items="${visitordata.visitors}">
				<li><c:out value="${visitor.name}"/>, <c:out value="${visitor.email}"/></li>
			</c:forEach>
		</ul><br><hr/>
		
		<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
		<a href="${contextPath}/visitorRegister/home" style="font-size: 20px">
			Generate Another Visitor
		</a> 
	</div>
</body>
</html>