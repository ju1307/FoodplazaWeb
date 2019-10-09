<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Food List</title>
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
<caption>FOOD MENUS</caption>
<tr><th>Id</th><th>Name</th><th>Price</th><th>Type</th><th colspan="3">Action</th></tr>
<c:forEach items="${foodlist}" var="food">
	<tr><td>${food.foodId}</td>
	<td>${food.foodName}</td>
	<td>${food.foodPrice}</td>
	<td>${food.foodType}</td>
	<c:if test="${f:contains(type,'admin')}">
	<td><a href="CommonFoodServlet?action=editFood&foodId=${food.foodId}">Edit</a></td>
</c:if>
	<c:if test="${f:contains(type,'admin')}">
	<td><a href="CommonFoodServlet?action=deleteFood&foodId=${food.foodId}">Delete</a></td>
	</c:if>
	<td><a href="CommonCartServlet?action=addToCart&foodId=${food.foodId}">Add to Cart</a></td>
	</tr>
</c:forEach>
</table>
</div>
<div id="footer">
<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>