<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h2>Login please:</h2>
	<form:form method="post" modelAttribute="user">
		User-name
			<form:input path="name" type="text"/>
			<br /> 
		Password 
			<form:input path="password" type="password"/> 
			<form:input path="role" type="hidden" value="u"/>
			<input type="submit" value="Login"/>
	</form:form>
	<h2>If you don't have Login, please go to the <a href="<c:url value="/register" />">registration</a></h2>
</body>
</html>