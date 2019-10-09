<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
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
<form action="CommonOrderServlet" method="post">
<table border="2">
<caption>CART LIST</caption>
<tr><th>Id</th><th>Name</th><th>Price</th><th>Type</th><th>Quantity</th><th colspan="2">Action</th></tr>
<c:forEach items="${foodlist}" var="food">
<tr><td>${food.foodId}</td>
	<td>${food.foodName}</td>
	<td>${food.foodPrice}<input type="hidden" name="foodPrice" value="${food.foodPrice}"></td>
	<td>${food.foodType}</td>
	<td><select name="quantity">
	    <c:forEach var="i" begin="1" end="100">
	    <option value="${i}">${i}</option>
	    </c:forEach>
	    </select></td>
	<td><a href="CommonCartServlet?action=deleteFromCart&foodId=${food.foodId}">Delete</a></td>
	</c:forEach>
</table>
<input type="submit" name="placeorder" value="placeorder"> 
<input type="hidden" name="action" value="placeorder">
</form>
</div>
<div id="footer">
<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>