<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FoodPlaza</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar nav-bar-default">
            <div class="container-fluid">
                <ul class="nav navbar-nav">
                    <c:if test="${f:contains(type,'admin')}">
					<li><a href="AddFoodT.jsp">Add Food</a></li>
					<li><a href="CommonCustomerServlet?action=getAllCustomer">Show Customers</a><li>
					</c:if>
                </ul>
            </div>
        </nav>
	
<p align="center">This template is designed by Jayesh Utekar.</p>
<p align="center">&copy; All Rights Reserved</p> 
</body>
</html>