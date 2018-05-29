<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "pro.dao.*" %>
    <%@ page import = "java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SELECTION OF OFFERS</title>
</head>
<body>
<img src='boat.jpg' style='position:fixed;top:OPX;left:OPX;width:100%;height:100%;z-index:-1;'>
	<% Collection <Salesperson> list = (Collection <Salesperson>)request.getAttribute("LIST");
		Customer cust =(Customer)request.getAttribute("CUST");
	%>
	<form action="BuyServlet" method="post">
	
	<br><b>PLEASE NOTE DOWN YOUR CUSTOMER ID<b> --><%=cust.getCustid() %>
	
	<center>
	<h1><u> SELECTION OF OFFERS  </u></h1>
	<ul>
		<% for(Salesperson sp : list) { 
		 %>
		<li>
			<b><%=sp.getOfferid() %>.</b>
			<b><%=sp.getDescription() %></b>
			<b><%=sp.getPrice() %></b>
			<b><%=sp.getValidfrom() %></b>
			<b><%=sp.getValidto() %></b><br><br>
			
		</li>
		<%} %>
	</ul>	
	</center>
	<b>ENTER YOUR CUSTOMER ID</b><aside><input type="text" name="custid"/></aside><br>
	<b>ENTER DEAL NO. YOU HAVE CHOSEN</b><aside><input type="text" name="offerid"/></aside><br> 
	<input type = "submit" value="SUBMIT"/>
	</form>		
		
</body>
</html>