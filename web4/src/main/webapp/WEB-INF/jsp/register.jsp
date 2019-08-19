<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	Registration form:
	<form:form method="post" modelAttribute="user">
		User-name
			<form:input path="name" type="text"/>
			<br /> 
		Password 
			<form:input path="password" type="password"/> 
			<form:input path="role" type="hidden" value="u"/>
			<input type="submit" value="Register"/>
	</form:form>
</body>
</html>