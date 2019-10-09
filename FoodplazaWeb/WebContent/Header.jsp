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
<body >
<nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">FoodPlaza</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="Index.jsp">Home</a></li>
                    <li><a href="CommonFoodServlet?action=getAllFoods">Browse Menu</a></li>
                    <c:if test="${user!=null}">
                    <li><a href="CommonCartServlet?action=showFoods">Show Cart</a></li>
                     <li><a href="CommonOrderServlet?action=getAllOrders">Show Orders</a></li>
                     </c:if>
                     <c:if test="${user==null}">
                    <li><a href="AddCustomerT.jsp">New User?...Register</a></li>
                    <li><a href="LoginT.jsp">Login</a></li>
                    </c:if>
                    <c:if test="${user!=null}">
					 <li><a href="CommonLoginServlet?action=logOut">Logout</a></li>
					</c:if>
                </ul>
            </div>
        </nav>
</body>
</html>