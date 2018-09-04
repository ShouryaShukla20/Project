<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@  taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form method="post" action="controller" commandName="persons">
		<input type="hidden" name="action" value="save" />
		<input type="hidden" name="id"
			value="${persons.id}<%-- Set this value to id property of car attribute --%>" />

		<table>
			<!-- input fields -->
			<tr>
				<td>Name<font color="red"><sup>*</sup></font>
				</td>
				<td><form:input type="text" path="name" value="${persons.name }" /></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><form:input type="text" path="age" value="${persons.age }" /></td>
			</tr>


			<!-- Save/Reset buttons -->
			<tr>
				<td colspan="2"><input type="submit" name="save" value="proceed" />
				 &nbsp;&nbsp; </td>
			</tr>
		</table>
	</form:form>


</body>
</html>