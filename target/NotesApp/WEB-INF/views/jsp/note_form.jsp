<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" contentType="text/html; charset="ISO-8859-1">
<title>Notes Form</title>
</head>
<body>

<form:form modelAttribute="noteForm" method="GET" action="/save">
	<form:hidden path="id"/>
<table>

<tr>
<td>Title:</td>
<td><form:input path="title"/>
</tr>

<tr>
<td>Description:</td>
<td><form:input path="description"/>
</tr>

<tr>
	<td></td>
	<td><button type="submit">Save</button>
</tr>

</table>
</form:form>

</body>
</html>