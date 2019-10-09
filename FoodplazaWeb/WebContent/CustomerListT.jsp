<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customers</title>
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
<table border="2">
<caption>CUSTOMERS</caption>
<tr><th>Id</th><th>Name</th><th>Address</th><th>Contact</th><th>Email</th><th>UserName</th><th>Password</th><th>Action</th><th>Action</th></tr>
<c:forEach items="${customerlist}" var="cust">
	<tr><td>${cust.custId}</td>
	<td>${cust.custName}</td>
	<td>${cust.custAddress}</td>
	<td>${cust.custContact}</td>
	<td>${cust.custEmail}</td>
	<td>${cust.custUserName}</td>
	<td>${cust.custPassword}</td>
	<td><a href="CommonCustomerServlet?action=editCustomer&custId=${cust.custId}">Edit</a></td>
	<td><a href="CommonCustomerServlet?action=deleteCustomer&custId=${cust.custId}">Delete</a></td>
	</tr>
</c:forEach>
</table>
</div>
<div id="footer">
<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>