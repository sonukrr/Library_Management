<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

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
<form method="post" action="UpdateSubscriberServlet">
<p>
<font color="white" size=4 face="helvetica">
Enter the Subscriber name :<br><input type="text" name="sName" ><br>
Enter your Phone Number :<br><input type="text" name="sPhoneNumber"><br>
Enter your Email Id :<br><input type="text" name="sEmailId"><br>


<input type="submit" name="submit" value="SUBMIT">
</font><br>
</p>
</form>
</fieldset>


</body>
</html>
</body>
</html>