<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>     
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="ISO-8859-1">
<title>Notes Page</title>
</head>
<body>

<a href="add">Add Notes</a>

<h1>Notes List</h1>
<table width="100%" border="1">
<tr>
	<th>ID</th>
	<th>Title</th>
	<th>Description</th>
	<th>Created Date</th>
	<th>Last Updated</th>
	<th colspan="2">Action</th>
</tr>

<c:forEach items="${listNote }" var="note">
	<tr>
		<td>${note.id }</td>
		<td>${note.title }</td>
		<td>${note.description }</td>
		<td>${note.createdTime }</td>
		<td>${note.updatedTime }</td>
		<td>
			<spring:url value="update/${note.id}" var="updateURL" />
			<a href="${updateURL }">Update</a>
		</td>
		
		<td>
			<spring:url value="delete/${note.id}" var="deleteURL" />
			<a href="${deleteURL }">Delete</a>
		</td>
	</tr>
</c:forEach>
</table>
</body>
</html>