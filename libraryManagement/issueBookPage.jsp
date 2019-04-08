<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor ="black">

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
<form method="post" action="IssueBookServlet">
<p>
<font color="white" size=4 face="helvetica">

Select Subscriber name :<br><select name="subscriberId">
<c:forEach items="${subscriberList }" var="sList">
<option value="${sList.subscriberId}">${sList.subscriberName}</option>
</c:forEach>
</select><br>

Selected Book ISBN number:<br><input  name="bookISBNNumber" value="${bookISBN }" ><br>
Book quantity Available:<br><input  name="bookQuantity" value="${bookQuantity}" ><br>
<input type="submit" name="submit" value="ISSUE">
</font><br>
</p>
</form>
</fieldset>


</body>
</html>