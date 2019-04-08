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

<table border=2>
		<caption>
			<b>All Book's List </b>
		</caption>

		<tr>
			<th>Book ISBN</th>
			<th>Book Name</th>
			<th>Publication Date</th>
			<th>Quantity</th>
			<th>Author</th>
			<th>Edit</th>
			

		</tr>
		<font color="black">
	
<c:forEach items="${allBookList }" var="list">
		
			<tr>
   <%-- <input type="hidden" name="bookISBN" value="${row.Book.ISBN }"> --%>
				
				<td>${list.book.booksIsbn}</td>
				<td>${list.book.name}</td>
				<td>${list.book.pubDate}</td>
				<td>${list.book.quantity}</td>
				<td>${list.authorName}</td>
				
		
				<td><a href="EditBookServlet?bookISBN=${list.book.booksIsbn }&bookName=${list.book.name }&bookPubDate=${list.book.pubDate }&bookQuantity=${list.book.quantity}&authorName=${list.authorName}"> EDIT </a></td>
				
		
			</tr>
		</c:forEach>
</font>
	</table>


</body>
</html>