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
	<div class="Login-reg-main border-round give-me-space-up-down">
		<h1>Register</h1>

		<form:form action="/register" method="post" modelAttribute="newUser">
			<div class="form-group">
				<form:label path="userName">User Name</form:label>
				<form:errors path="userName" />
				<form:input path="userName" />
			</div>
			<div class="form-group">
				<form:label path="email">Email</form:label>
				<form:errors path="email" />
				<form:input path="email" />
			</div>
			<div class="form-group">
				<form:label path="password">Password</form:label>
				<form:errors path="password" />
				<form:input path="password" />
			</div>

			<div class="form-group">
				<form:label path="confirm">Confirm Password</form:label>
				<form:errors path="confirm" />
				<form:input path="confirm" />
			</div>

			<input type="submit" value="Submit" />
		</form:form>

		<hr />
		<h1>Login</h1>

		<form:form action="/register" method="post" modelAttribute="newLogin">

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
</body>
</html>