<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>
<ul>
<li> Current time: <%= new java.util.Date() %>
<li> Server: <%=application.getServerInfo() %>
<li> Session ID: <%=session.getId() %>
<li> Op name: <%=System.getProperty("os.name") %>
<li> user Name: <%=System.getProperty("user.name") %>
<li> Home dir Name: <%=System.getProperty("user.home") %>
<li> user time zone: <%=System.getProperty("user.timezone") %>
<li> Directory: <%=System.getProperty("java.home") %>
<li> Java version: <%=System.getProperty("java.version") %>
</ul>
</h1>

</body>
</html>