<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	
	<%
	if(request.getSession().getAttribute("badLogin")!=null) {
	%>
	<h2>* Invalid Username and/or password</h2>
	<%	}
	if(request.getSession().getAttribute("attempts")=="3")
	{
	%>
	<h1>Login failed</h1>
	<h1>You have tried more than 3 times, please try it again</h1>
	<form method="post" action="login.jsp">
		<input type='submit' name='Retry' value="1">
	</form>
	<% } else { %>
	<h1>Login</h1>
	<form method="POST" action="Login">
		<label for="email">Email: </label> <input type="text" name="email"/><br>
		<label for="passwd">Password: </label> <input type="password" name="passwd"/>
		<input type='submit' name='Login'>
	</form>
	<% } %>
</body>
</html>