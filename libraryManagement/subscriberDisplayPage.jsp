<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<table border=2>
		<caption>
			<b>Availaible Subscriber's List </b>
		</caption>

		<tr>
			<th>Subscriber ID</th>
			<th>Name</th>
			<th>Phone Number</th>
			<th>EmailId</th>
			<th>Book's Issued</th>
			<th>EDIT</th>

		</tr>
<c:forEach items="${subList }" var="list">	
			<tr>
				<td>${list.subscriber.subscriberId}</td>
				<td>${list.subscriber.subscriberName}</td>
				<td>${list.subscriber.phoneNumber}</td>
				<td>${list.subscriber.emailId}</td>
				<td>${list.booksIssued}</td>
				<td><a href="UpdateSubscriberServlet?sID=${list.subscriber.subscriberId}&sName=${list.subscriber.subscriberName}&sPhone=${list.subscriber.phoneNumber}&sMail=${list.subscriber.emailId}">EDIT</a></td>
		
		
			</tr>
		</c:forEach>
</font>
	</table>



</center>
</body>
</html>