<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JAVA</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>Hello Users</h1>
	
	<div>
	<div>
	<form:form action="/register" method="post" modelAttribute="newUser">
	<%-- <form:input type="hidden" path"user" value="${logUser.userName}"/> --%>
		<p>
			<form:label path="userName">User Name</form:label>
			<form:errors path="userName" />
			<form:input path="userName" />
		</p>
		<p>
			<form:label path="email">Email</form:label>
			<form:errors path="email" />
			<form:input path="email" />
		</p>
		<p>
			<form:label path="password">Password</form:label>
			<form:errors path="password" />
			<form:input path="password" />
		</p>
		<p>
			<form:label path="confirm">Confirm Password</form:label>
			<form:errors path="confirm" />
			<form:input path="confirm" />
		</p>

		<input type="submit" value="Submit" />
	</form:form>
	
	<hr />
	
	<div>
	<form:form action="/login" method="post" modelAttribute="newLogin">
	<%-- <form:input type="hidden" path"user" value="${logUser.userName}"/> --%>
		<p>
			<form:label path="email">Email</form:label>
			<form:errors path="email" />
			<form:input path="email" />
		</p>
		<p>
			<form:label path="password">Password</form:label>
			<form:errors path="password" />
			<form:input path="password" />
		</p>
		<input type="submit" value="Submit" />
	</form:form>
	
	</div>
	
	</div>
	</div>
</body>
</html>