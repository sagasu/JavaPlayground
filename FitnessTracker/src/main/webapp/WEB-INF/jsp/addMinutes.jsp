<%@ page language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<body>
<h1>Add minutes</h1>

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

</body>
</html>