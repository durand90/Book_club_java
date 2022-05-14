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
		<h1>Hello edit</h1>
		
		<form:form action="/books/${id}" method="post" modelAttribute="books">
		<input type="hidden" name="_method" value="put">
			<p>
				<form:label path="title">Title</form:label>
				<form:errors path="title" />
				<form:input path="title" />
			</p>
			<p>
				<form:label path="author">Author</form:label>
				<form:errors path="author" />
				<form:input path="author" />
			</p>
			<p>
				<form:label path="thoughts">My Thoughts</form:label>
				<form:errors path="thoughts" />
				<form:textarea path="thoughts" />
			</p>
			
			<input type="submit" value="Submit" />
		</form:form>
</body>
</html>