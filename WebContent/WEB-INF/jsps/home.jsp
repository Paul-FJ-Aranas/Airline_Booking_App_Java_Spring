<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crossover</title>
</head>
<body>
	<p>Welcome to Paul's Airline Booking Site!</p>


	<sec:authorize access="!isAuthenticated()">
		<p>
			<a href="${pageContext.request.contextPath}/newaccount">Create
				New Account</a>
		</p>
	</sec:authorize>

	<sec:authorize access="!isAuthenticated()">
		<p>
			<a href="${pageContext.request.contextPath}/login">Log in</a>
		</p>
	</sec:authorize>
	
	<sec:authorize access="isAuthenticated()">
		<form action="${pageContext.request.contextPath}/loggedout">

    <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<input type="submit" value="logout">

		</form>
	</sec:authorize>

	<sec:authorize access="hasAuthority('admin')">
		<p>
			<a href="${pageContext.request.contextPath}/admin"/>Admin</a>
		</p>
	</sec:authorize>




</body>
</html>