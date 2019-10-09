<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Orders</title>
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
<tr><th>Order Id</th><th>Total Bill</th><th>Order Date</th><th>Order Status</th><th>Action</th></tr>
<c:forEach items="${orderList}" var="order">
	<tr><td>${order.orderId}</td>
	<td>${order.totalBill}</td>
	<td>${order.orderDate}</td>
	<td>${order.orderStatus}</td>
	<c:if test="${f:contains(type,'user')}">
	<td><a href="CommonOrderServlet?action=deleteMyOrder&orderId=${order.orderId}">Delete</a></td>
	</c:if>
	<c:if test="${f:contains(type,'admin')}">
	<td>
	<select name="type">
	<option value="confirmed">CONFIRMED</option>
	<option value="dispatched">DISPATCHED</option>
	<option value="delivered">DELIVERED</option>
	</select>
	</td>
	</c:if>
	
	</tr>
</c:forEach>
</table>
</div>
<div id="footer">
<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>