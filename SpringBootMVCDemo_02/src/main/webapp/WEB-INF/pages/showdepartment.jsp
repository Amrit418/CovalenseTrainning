<%@page import="com.covalense.beans.Department"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Department page</title>
</head>
<body>
	<h2>Department Details</h2>
	<table border="3" bgcolor="#87CEEB" style="text-align: center;">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>



		<%
		List<Department> depts = (List<Department>) request.getAttribute("depts");
		for (Department dept : depts) {
		%>

		<tr>
			<td><%=dept.getId()%></td>
			<td><%=dept.getName()%></td>
			<td><a href="editDept?id=<%=dept.getId()%>">Edit</a></td>
			<td><a href="deleteDept?id=<%=dept.getId()%>">Delete</a></td>
		</tr>



		<%
		}
		%>
	</table>
	<br><br>
	<a href="/">Home</a>
	<a href="getDepts">ShowAllEmployee</a>

</body>
</html>

