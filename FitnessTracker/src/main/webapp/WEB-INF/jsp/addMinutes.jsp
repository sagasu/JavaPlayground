<%@ page language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
<h1>Add minutes</h1>

<form:form commandName="exercise">
	<table>
		<tr>
			<td>Minutes exercises for today</td>
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