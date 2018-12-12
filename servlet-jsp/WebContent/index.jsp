<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="Controller" method="get">
	Input an Integer: <input type="text" name="value"><br>
	<input type="radio" name="method" value="square" checked>Square<br>
	<input  type="radio" name="method" value="factorial"> Factorial<br>
	<input  type="radio" name="method" value="random"> Random<br>
	<input type="submit" value="Calculate">
</form>
	
<form action="StudentControl" method="get">
	<input type="text" name="studentName">
	<input type="submit" value="submit">

</form>
	
	 


</form>

</body>
</html>