<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%if(request.getSession().getAttribute("badLogin")!=null) {%>
	<p style="color:red;">* Invalid Username and/or password</p>
	<%}
	
	if(request.getAttribute("attempts") == "3"){%>
	<h1>Max Failed Login Attempts Reached</h1>
	<p>You have failed more than 3 times please try it again</p>
	<form method="post" action="login.jsp">
		<input type='submit' name='Retry' value="1">
	</form><%} else { %>
	
	
	<h1>Login</h1>
	<form method="POST" action="Login">
		<label for="email">Email: </label> <input type="text" name="email"/><br>
		<label for="passowrd">Password: </label> <input type="password" name="passwd"/>
		<input type='submit' name='Login'>
	</form>
	
	
	<% } %>
	
	
</body>
</html>