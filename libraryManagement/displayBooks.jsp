<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="styleSheet" type="text/css" href="webPageContent.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border=2>
		<caption>
			<b>Availaible Book's List </b>
		</caption>

		<tr>
			<th>Book ISBN</th>
			<th>Book Name</th>
			<th>Publication Date</th>
			<th>Quantity</th>
			<th>Author Name</th>
			<th>ISSUE</th>
			<th>RETURN</th>

		</tr>
		<font color="black">
		
<c:forEach items="${tableData }" var="list">
		
			<tr>
   <%-- <input type="hidden" name="bookISBN" value="${row.Book.ISBN }"> --%>
				
				<td>${list.book.booksIsbn}</td>
				<td>${list.book.name}</td>
				<td>${list.book.pubDate}</td>
				<td>${list.book.quantity}</td>
				<td>${list.authorName}</td>
				
		
				<td><a href="IssueBookServlet?action=issue&bookISBN=${list.book.booksIsbn }&bookQuantity=${list.book.quantity }"> Issue </a></td>
				<td><a href="ReturnBookServlet?action=return&bookISBN=${list.book.booksIsbn }&bookQuantity=${list.book.quantity }&bookName=${list.book.name }"> Return </a></td>
		
			</tr>
		</c:forEach>
</font>
	</table>




</body>
</html>