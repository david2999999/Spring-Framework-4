<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Location Details</title>
	<style>
		input[type=text] {
			padding: 10px;
			margin: 10px;
			font-size: 20px;
		}
		
		input[type=submit]{
			border: none;
			background-color: #ACAF50;
			color:white;
			padding: 16px;
			margin: 16px;
			cursor: pointer;
			font-size: 20px;
		}
		
		h2{
			color: #08298A;
			text-align:center;
		}
	</style>
</head>
<body>
	<h2 style="color: #DF0101">
		<c:out value="${greeting}"></c:out>
	</h2>
	<hr/>
	
	<h2>Submit your location for a list of organization</h2>
	<div style="text-align: center">
		<form action="listOrgs">
			<input type="text" name="locationName">
			<input type="submit" name="Get Organization">
		</form>
	
	</div>
</body>
</html>



















