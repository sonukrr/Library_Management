<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<body bgcolor="grey">

<style>
fieldset{
display:block;
margin-left:25%;
margin-right:25%;
padding-top:35%
padding-bottom:0.625em
padding-left:2 em
padding-right:2 em
border:20px groove(internal value);
}
</style>
<fieldset>
<form method="post" action="EditBookServlet">
<p>
<font color="white" size=4 face="helvetica">
The book ISBN number :<br><input type="number" name="bookISBN" value="${bookISBN}"><br>
Enter the book Name :<br><input type="text" name="bookName" value="${bookName}"><br>

<label for="start">Enter the book publication date:<br></label>
<input type="date" id="start" name="bookPublicationDate" value="${bookPubDate}"><br>

quantity of books to update :<br><input type="number" name="bookQuantity" value="${bookQuantity}"><br>
Book Author Name :<br><input type="text" name="bookAuthorName" value="${authorName}"><br> 
<input type="hidden" name="origAuthorName" value="${authorName}">


<input type="submit" name="submit" value="UPDATE">
</font><br>
</p>
</form>
</fieldset>


</body>
</html>


</body>
</html>