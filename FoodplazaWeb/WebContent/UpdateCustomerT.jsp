<%@page import="com.foodplaza.pojo.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer</title>
<link rel="stylesheet" href="styles.css" />
</head>
<body>
<div id="links">
<jsp:include page="Header.jsp"></jsp:include>
</div>
<div id="tab">
<table align="center">
<tr>
	<td><img src="Images/dish1.jpeg" height="200px" width="220px"/></td>
	<td><img src="Images/dish2.jpeg" height="200px" width="220px"/></td>
	<td><img src="Images/dish3.jpeg" height="200px" width="220px"/></td>
	<td><img src="Images/dish4.jpeg" height="200px" width="220px"/></td>
</tr>
<tr>
	<td>Bangada Fry</td>
	<td>Paplet Fry</td>
	<td>Kolambi Fry</td>
	<td>Crab Fry</td>
</tr>
</table>
</div>
<div id="main">
<%Customer cust=(Customer)session.getAttribute("customer"); %>
<form action="CommonCustomerServlet" method="post">
<table>
<tr><td>Customer id:</td><td><input type="text" name="cid" value="<%=cust.getCustId()%>" readonly="readonly"></td></tr>
<tr><td>Customer name:</td><td><input type="text" name="cname" value="<%=cust.getCustName()%>" readonly="readonly"></td></tr>
<tr><td>Customer email:</td><td><input type="text" name="cemail" value="<%=cust.getCustEmail()%>" readonly="readonly"></td></tr>
<tr><td>Customer password:</td><td><input type="text" name="cpass" value="<%=cust.getCustPassword()%>" required></td></tr>
<tr><td>Customer contact:</td><td><input type="text" name="ccnt" value="<%=cust.getCustContact()%>" required></td></tr>
<tr><td>Customer address:</td><td><input type="text" name="caddr" value="<%=cust.getCustAddress()%>" required></td></tr>
<tr><td><input type="submit" value="SUBMIT"> </td><td><input type="reset" value="RESET"></td></tr>
</table>
<input type="hidden" name="action" value="updateCustomer">
</form>
</div>
<div id="footer">
<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>