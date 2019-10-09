<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="styles.css" />
<link rel="stylesheet" href="css/bootstrap.min.css">
	 
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
<form action="CommonLoginServlet" method="post" class="form-horizontal">
<h3  class="col-xs-offset-4">LOGIN FORM</h3>

<div class="form-group">
                <label for="usertype" class="control-label col-xs-offset-2 col-xs-4">Type</label>
                 <div class="col-xs-4">
                <select name="type" id="usertype">
					<option value="user">USER</option>
					<option value="admin">ADMIN</option>
				</select>
				</div>
</div>
 <div class="form-group">
                <label for="inputUser" class="control-label col-xs-offset-2 col-xs-4">User Name</label>
                 <div class="col-xs-4">
                <input type="text" name="uName" class="form-control" id="inputUser" required>
                </div>
</div>
<div class="form-group">
                <label for="inputPassword" class="control-label col-xs-offset-2 col-xs-4">Password</label>
                <div class="col-xs-4">
                <input type="password" name="password" class="form-control" id="inputPassword" required>
                 </div>
</div> 
<div class="form-group">
            <div class="col-xs-offset-6 col-xs-4">
                <button type="submit" class="btn btn-primary">Login</button>
            </div>
</div>
<input type="hidden" name="action" value="login">
</form>
</div>
<div id="footer">
<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>