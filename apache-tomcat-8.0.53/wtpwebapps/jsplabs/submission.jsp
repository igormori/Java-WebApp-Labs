<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="student" class="person.bean.Student">

<jsp:setProperty name="student" property="firstName" value='<%=request.getParameter("firstname") %>'/>
<jsp:setProperty name="student" property="lastName" value='<%=request.getParameter("lastname") %>'/>
<jsp:setProperty name="student" property="age" value='<%=Integer.parseInt(request.getParameter("age"))	 %>'/>


</jsp:useBean>
<p>Student first name:
	<jsp:getProperty name="student" property="firstName"/>
</p>

<p>Student last name:
	<jsp:getProperty name="student" property="lastName"/>
</p>

<p>Student age:
	<jsp:getProperty name="student" property="age"/>
</p>


<p>Student full name:
	<%= student.getFullName() %>
</p>



</body>
</html>