<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import = "pro.dao.*" %>
    <%@ page import = "java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CONFIRMATION STATUS</title>
</head>
<body>
<img src='Visit_ANU_with_travel_grant.jpg' style='position:fixed;top:OPX;left:OPX;width:100%;height:100%;z-index:-1;'>
<!-- Collection <Salesperson> list1 = (Collection <Salesperson>)request.getAttribute("VIEW"); -->
<%	CustOffer co = (CustOffer)request.getAttribute("CONFIRM");
%><form>
<center>
<br><h1><u>CONFIRMATION STATUS</u></h1>
<b>STATUS:<%=co.getStatus() %></b><br><br><br>
<b>STATUS=0 --> YOUR REQUEST IS PENDING<br><br>
STATUS=1 --> YOUR BOOKING HAS BEEN CONFIRMED</b><br><br><br>
<b>TO GO BACK TO LOGIN PAGE,<a href="login.html">CLICK HERE</a></b>



	
	</center></form>
</body>
</html>