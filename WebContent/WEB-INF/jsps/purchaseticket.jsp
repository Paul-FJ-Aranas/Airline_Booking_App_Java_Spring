<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



		Your Tickets
		
			<table class="usertable">
				<tr>
					<td class="label">Amount:</td>
					<td><input path="amount"
							name="amount" type="text" /><br/></td>
				
				</tr>
				<tr>
					<td class="label">From:</td>
					<td><input path="from" name="from"
							type="text" /><br /></td>
					
				</tr>
				<tr>
					<td class="label">To:</td>
					<td><input id="password" 
							path="to" name="to" type="text" /><br /></td>
				

				</tr>
				
					<td class="button"><input 
						value="Purchase Ticket" type="submit" /></td>
				</tr>
			</table>
		
		
		
		
		<tr>
			<td>Amount</td>
			<td>Price</td>
			<td>Currency</td>
			<td>From</td>
			<td>Destination</td>
		</tr>
		<c:forEach var="ticket" items="${ticketArray}">
			<tr>
				<td><c:out value="${ticket.amount}"></c:out></td>
				<td><c:out value="${ticket.price.amount}"></c:out></td>
				<td><c:out value="${ticket.price.currency}"></c:out></td>
				<td><c:out value="${ticket.route.from}"></c:out></td>
				<td><c:out value="${ticket.route.to}"></c:out></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>