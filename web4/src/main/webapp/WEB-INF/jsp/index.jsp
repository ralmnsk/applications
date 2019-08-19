<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>MAIN</title>
	
</head>
<body>
<h2>This is a start page.</h2>
<h3><a href="<c:url value="/login" />">Login</a></h3>
<h3><a href="<c:url value="/register" />">Register</a></h3>
</body>
</html>
