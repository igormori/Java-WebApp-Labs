<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		System.out.println("Evaluating date now");
		java.util.Date date = new java.util.Date();
	%>
	
	 The Time now is:
	 
	 <%
	 	out.println(String.valueOf(date));
		out.println("</br> Your machine`s address is: ");
		out.println(request.getRemoteHost());
		
	 %>


</body>
</html>