<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Airline Offers</title>
</head>
<body>
<p><a href="${pageContext.request.contextPath}/yourtickets">Your Tickets</a></p>
<p><a href="${pageContext.request.contextPath}/purchaseticket">Purchase Tickets</a></p>
	<table class="offers">
		Flights
		<tr>
			<td>Price</td>
			<td>Currency</td>
			<td>From</td>
			<td>Destination</td>
		</tr>
		<c:forEach var="offer" items="${offerArray}">
			<tr>
				<td><c:out value="${offer.price.amount}"></c:out></td>
				<td><c:out value="${offer.price.currency}"></c:out></td>
				<td><c:out value="${offer.route.from}"></c:out></td>
				<td><c:out value="${offer.route.to}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>

