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

<jsp:setProperty name="student" property="firstName" value="Zara"/>
<jsp:setProperty name="student" property="lastName" value="Ali"/>
<jsp:setProperty name="student" property="age" value="10"/>
<jsp:setProperty name="student" property="id" value="10"/>

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

<p>Student id:
	<jsp:getProperty name="student" property="id"/>
</p>


<p>Student full name:
	<%= student.getFullName() %>
</p>

<form action="submission.jsp" method="post">
  First name:<br>
  <input type="text" name="firstname">
  <br>
  Last name:<br>
  <input type="text" name="lastname" >
  <br>
  Age:<br>
  <input type="text" name="age" >
  <br>
  id:<br>
  <input type="text" name="id" >
  <br><br>
  <input type="submit" value="Submit">

</form>


</body>
</html>