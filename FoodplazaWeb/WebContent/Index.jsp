<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FoodPlaza</title>
<link rel="stylesheet" href="styles.css" />
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body >
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
<marquee behavior="alternate"><h1 id="h1">Amantran</h1></marquee>
<h3 id="head" >Welcome to</h3>
<h3  id="head" class="heading3"><i>"Amantran Sea Special Restaurant"</i></h3>   
<p>We offer varities of sea special food in resonable rates. Our restaurant is special for <b>Sumurai fry</b></p>
<p>You can browse the menus to check out other varities</p>
</div>
<div id="footer">
<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>