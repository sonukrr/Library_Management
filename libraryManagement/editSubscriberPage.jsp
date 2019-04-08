<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
</head>

<body bgcolor="grey">

<fieldset>
<form method="post" action="editSubscriberServlet">
<p>
<font color="white" size=4 face="helvetica">
Subscriber's ID :<br><input type="number" name="sID" value="${sID}"><br>
Subscriber's Name :<br><input type="text" name="sName" value="${sName}"><br>
Subscriber's Phone Number :<br><input type="number" name="sPhone" value="${sPhone}"><br>
Subscriber's Email ID :<br><input type="text" name="sMail" value="${sMail}"><br>

<input type="submit" name="submit" value="UPDATE">
</font><br>
</p>
</form>
</fieldset>


</body>
</html>
