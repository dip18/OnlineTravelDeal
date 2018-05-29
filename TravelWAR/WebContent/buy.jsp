<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REQUEST RECEIVED</title>
</head>
<body>
<img src='22.JPG' style='position:fixed;top:OPX;left:OPX;width:100%;height:100%;z-index:-1;'>
<% Object ob = request.getAttribute("BOOK"); %>
<form>
<center>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<b>
YOUR REQUEST HAS BEEN RECEIVED..........<br><br>
TO GO BACK TO LOGIN PAGE,<a href="login.html">CLICK HERE</a></b>
</center>
</form>
</body>
</html>