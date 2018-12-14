<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Home</title>

</head>
<body>
<h1>
	Create 
</h1>
<form:form modelAttribute="userValues" action="save" method="POST">
Principle: <form:input path="principle"/><br>
Rate Of Interest: <form:input path="rateofinterest"/><br>
Tenure: <form:input path="tenure"/><br>
Number Of installenments: <form:input path="noOfInstallenment"/><br>
<input type="submit" value="Submit">

</form:form>
</body>
</html>
