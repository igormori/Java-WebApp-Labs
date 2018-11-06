<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@page import="calculation.basic.*" %>
<% Calculation c= new Calculation(); %>
<% int number = Integer.parseInt(request.getParameter("number"));
	%>
 2 square is:<%=c.square(number) %>
</body>
</html>