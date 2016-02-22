<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form commandName="goal">
	<table>
		<tr>
			<td>Enter minutes:</td>
			<td>
				<form:input path="minutes"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="Enter goal minutes">
			</td>
		</tr>
	</table>
</form:form>
<!-- goal is kept in session -->
<h1>our goal for today is ${goal.minutes}</h1>
</body>
</html>