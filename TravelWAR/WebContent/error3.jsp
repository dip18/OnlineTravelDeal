<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ERROR IN LOGGING IN AS EXISTING CUSTOMER</title>
</head>
<body>
<img src='mood-maldives-wallpaper-travel-nature-sea-wh.jpg' style='position:fixed;top:OPX;left:OPX;width:100%;height:100%;z-index:-1;'>
<form>
<center>
<br><br><h1><u>ERROR IN LOGGING IN AS EXISTING CUSTOMER</u></h1>
<b><%
String st = (String)request.getAttribute("ERRMSG");
%></b>
<h1><blink>ERROR</blink></h1><br>
<b><%= st.concat("..!!") %></b><br><br>
<b>TO GO BACK TO LOGIN PAGE,<a href="login.html">CLICK HERE</a></b>
</center>
</form>
</body>
</html>