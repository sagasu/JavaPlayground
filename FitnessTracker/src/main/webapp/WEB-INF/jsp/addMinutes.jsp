<%@ page language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<body>
<h1>Add minutes</h1>

Language : <a href="?Language=en" >en</a> |<a href="?Language=es" >es</a> 
<form:form commandName="exercise">
	<table>
		<tr>
			<td><spring:message code="goal.text" /></td>
			<td>
				<form:input path="minutes"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="Enter excercise">
			</td>
		</tr>
	</table>
</form:form>
<!-- goal is kept in session -->
<h1>our goal for today is ${goal.minutes}</h1>
</body>
</html>