<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
<script>

$(function(){
	$("#submitButton").click(function(){
		var password=$("#password").val();
		var confirmPassword=$("#confirmPassword").val();
	if(password == confirmPassword){
			$("#Details").submit();
		}
	else{
		alert("Password did not match");
		return false;
		}
		});
	});
</script>
</head>
<body>
<h1>
	Welcome Admin 
</h1>



<form:form commandName="Details" method="POST">
Admin Name: <form:input path="username"/><br>
Password: <form:password path="password"/><br>
ConfirmPassword<input type ="password" id="confirmPassword"><br><br>
<input type="submit" id="submitButton"value="Submit">

</form:form>
</body>
</html>
