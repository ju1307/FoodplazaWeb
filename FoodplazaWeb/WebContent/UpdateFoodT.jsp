<%@page import="com.foodplaza.pojo.Food"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upadte Food</title>
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
<% Food food=(Food)session.getAttribute("food");%>
<form action="CommonFoodServlet" method="post">
<table>
<tr><td>Food id:</td><td><input type="text" name="fid" value="<%=food.getFoodId()%>" readonly="readonly"></td></tr>
<tr><td>Food name:</td><td><input type="text" name="fname" value="<%=food.getFoodName()%>" required></td></tr>
<tr><td>Food price:</td><td><input type="text" name="fpricce" value="<%=food.getFoodPrice()%>" required></td></tr>
<tr><td>Food type:</td><td><input type="text" name="ftype" value="<%=food.getFoodType()%>" required></td></tr>
<tr><td><input type="submit" value="SUBMIT"> </td><td><input type="reset" value="RESET"></td></tr>
</table>
<input type="hidden" name="action" value="updateFood">
</form>
</div>
<div id="footer">
<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>