<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
		<%! private String color= "red";
			private double randNumber = 0;%>
				
<body bgcolor=<%out.println(color); %>>


<% if(randNumber > 0.5 && randNumber < 0.6 ){color = "blue";
											}else{color="red";} %>	






</body>
</html>