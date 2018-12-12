<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Max Failed Login Attempts Reached</h1>
	<p>You have failed more than 3 times please try it again</p>
	<form method="post" action="login.jsp">
		<input type='submit' name='Retry' value="1">
	</form>

</body>
</html>