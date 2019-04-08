<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="styleSheet" type="text/css" href="webPageContainers.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>

<body bgcolor="#3c3c3c">


<form  name="login" method="post" action="LoginServlet">
<font color="white" size=4 face="helvetica">
<fieldset>
<p><center>
<font color="blue"><h2><u>Welcome to Library-Management</u></h2></font>
<font color="cyan" size=3>${error}<br></font>
Enter Username :<br><input type="text" name="username"><br><br>
Enter Password  :<br><input type="password" name="password" ><br><br>
<input type="submit" name="submit" value="LOGIN">
</center>
</fieldset>
</font>
</form>
</body>
</html>