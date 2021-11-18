<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<link rel="icon"
	href="https://www.freepnglogos.com/uploads/youtube-play-red-logo-png-transparent-background-6.png">

<meta charset="ISO-8859-1">
<title>RegEmployee</title>
</head>
<body>
	<h2>Employee Registration</h2>
	<form:form action="regemp" method="post" modelAttribute="employee">
		<!--  <form:label path="id">ID</form:label>
	<form:input path="id" /><br><br> -->
		<form:label path="name">Name</form:label>
		<form:input path="name" />
		<br>
		<br>
		<input type="submit" value="Register">
	</form:form>
	<!--  <form action="regemp" method="post">
		Id:<input type="text" name="id"><br> <br> Name:<input
			type="text" name="name"><br> <br> DeptNo:<input
			type="text" name="deptno"><br> <br> <input
			type="submit" name="Register"> <input type="reset"
			name="Cancel">
	</form>
	-->
</body>
</html>

