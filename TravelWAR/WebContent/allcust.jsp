<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import = "pro.dao.*" %>
    <%@ page import = "java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LIST OF CUSTOMER</title>
</head>
<body>
<img src='166171.jpg' style='position:fixed;top:OPX;left:OPX;width:100%;height:100%;z-index:-1;'>
<% Collection <Customer> list = (Collection <Customer>)request.getAttribute("LIST"); %>

<form action="ConfirmServlet" method="post">
<center>
<h1><u>LIST OF CUSTOMER</u></h1>
<h3><ul>
	<% for(Customer cust : list) {
	%>
	<li>
	<b><%= cust.getCustid()%></b>
	<b><%= cust.getCname() %></b>
	</li>
	<% } %>
</ul></h3>
<b>TO CONFIRM REQUEST,ENTER CUSTOMER ID</b> --><input 	type="text" name="confirm"/><br>
<input type="submit" value="CONFIRM">
</center>
</form>
</body>
</html>