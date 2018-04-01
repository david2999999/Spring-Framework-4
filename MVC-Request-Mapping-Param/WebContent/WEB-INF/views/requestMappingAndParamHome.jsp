<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>@RequestMapping and @RequestParam Test Bed</title>
<style>
	input[type=text]{
		padding: 10px;
		margin: 10px;
		font-size: 20px
	}
	
	input[type=submit]{
		border:none;
		background-color: #4CAF50;
		color: white;
		padding: 16px;
		margin: 16px;
		cursor:pointer;
		font-size: 20px;
	}
	
	h2{
		color: #08298A;
		text-align: center;
	}
</style>
</head>
<body>
	<div align="left">
		<h2 align="center">
			Hello, Welcome to @RequestMapping & RequestParam Test Bed
		</h2><hr/>
		
		<form action="test1">
			<h3>
				Test 1: Testing @RequestParam without explicit Attributes
			</h3>
			<label id="organization-name">Organization Name</label>
			<input type="text" name="orgName" placeholder="Enter Organization Name" size="40">
			<input type="submit" value="Submit"/>
		</form>
		
		<br><br>
		
		<form action="test2">
			<h3>
				Test 2: Testing @RequestMapping 'method' attribute
			</h3>
			<label id="organization-name">Organization Name</label>
			<input type="text" name="orgName" placeholder="Enter Organization Name" size="40">
			<input type="submit" value="Submit"/>
		</form>
		
				<br><br>
		
		<form action="test3">
			<h3>
				Test 3: Testing @RequestMapping fallback feature
			</h3>
			<input type="submit" value="Submit"/>
		</form>
	</div>
	








</body>
</html>














