<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "pro.dao.*" %>
    <%@ page import = "java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>YOUR DEALS</title>
</head>
<body>
<img src='boat.jpg' style='position:fixed;top:OPX;left:OPX;width:100%;height:100%;z-index:-1;'>

<% Object ob = (Object)request.getAttribute("MER");  %>
<% Object ob1 = (Object)request.getAttribute("MERNAME");  %>
<% Collection <Salesperson> list = (Collection <Salesperson>)request.getAttribute("LIST"); %>
<form action="AllcustServlet" method="post"> 
<center>
<h1><u>YOUR DEALS</u></h1>
<b>MERCHANT NAME:</b><b><%=ob1.toString() %></b><br><br>
<b>DEALS</b> --> <br>
<ul>
	<%
		for(Salesperson sp : list) {
	%>
			<b><%=sp.getOfferid() %>.</b>
			<b><%=sp.getDescription() %></b>
			<b><%=sp.getPrice() %></b>
			<b><%=sp.getValidfrom() %></b>
			<b><%=sp.getValidto() %></b><br>
			
	<% } %>
</ul>		
<b>TO SEE ALL CUSTOMER REQUESTS AGAINST THIS DEAL,ENTER OFFER ID</b> --><input type="text" name="offerid"/><br>
<input type="submit" value="SUBMIT"/>
</center>
</form>
</body>
</html>