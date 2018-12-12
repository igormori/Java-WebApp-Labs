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
	if(request.getSession().getAttribute("portAbbreviation")==null &&
		request.getSession().getAttribute("portName")==null)
	{
	%>
	<h1>Online Ontario Statutory Holiday Repository</h1>
	<p>Please select month and year to perform statutory holiday lookup</p>
	<form method="post" action="ProcessStatutoryHoliday">
		<fieldset>
			<select id="month" name="month">
				<option disabled selected value="">Month</option>
				<option	value="January">January</option>
				<option	value="Febuary">Febuary</option>
				<option	value="March">March</option>
				<option	value="April">April</option>
				<option	value="May">May</option>
				<option	value="June">June</option>
				<option	value="July">July</option>
				<option	value="August">August"</option>
				<option	value="September">September</option>
				<option	value="October">October</option>
				<option	value="November">November</option>
				<option	value="December">December</option>
			</select>
		
		 
			<select id="year" name="year">
				<option disabled selected value="">year</option>
				<option	value="2018">2018</option>
				<option	value="2019">2019</option>
				
			</select>
			</fieldset>
		
		<hr>
		<input type="submit" name="submit">
	</form>
	<% } else { %>
	<h1>Online Ontario Statutory Holiday Repository</h1>
	<form action="ProcessStatutoryHoliday" method="post">
		<fieldset>
			<label>The statutory holidays in Ontario in <strong><%= request.getSession().getAttribute("holiday") %>
		</fieldset>
		<hr>
		<input type="submit" name="continue" value="Continue">
		<input type="submit" name="logout" value="Logout">
	</form>
	<% } %>

</body>
</html>