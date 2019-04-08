<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="styleSheet" type="text/css" href="webPageContainers.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#3f69aa">

<fieldset>
<form method="post" action="SearchServlet">
<center>
<font color="white" size=4 face="helvetica">
<font color="cyan"><u>Search Options:<br></u></font>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="bookOpt">Search by Book Name<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="authorOpt" >Search by Author Name<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="subscriberOpt" >Search by Subscriber Name or Subscriber ID
<br><u>Enter the name:<input type="text" name="searchParameter"></u><br>
</font><br>
<input type="submit" value="SEARCH" name="submit">
</center>
</form>
</fieldset>
<br><br><br><br>

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
<form method="post" action="UpdateServlet">
<center>
<font color="white" size=4 face="helvetica">

<a href="updateBookPage.jsp" >Add new Book Details</a><br>
<a href="updateSubscriberPage.jsp" >Add new Subscriber</a><br>
<a href="editBookDetailsServlet" >View/Edit Books</a><br>

</font><br>

</center>
</form>
</fieldset>
<br><br>
<form  action="loginPage.jsp">
<center><input type="submit" name="logout" value="LOGOUT" ></center>
</form>
</body>
</html>