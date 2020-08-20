<%@ page language="java" import="by.htp.les02.entity.User" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration form</title>
</head>
<body>
	<%
		User userX = (User) request.getAttribute("user");
		if (userX==null) {
		userX=new User();
		}
	
	%>
	<br></br>
	<table>
		<tbody>
			<tr>
				<td>You first name    </td>
				<td><% out.println(userX.getFirstName());%></td>
			</tr>
			<tr>
				<td>You login</td>
				<td><% out.println(userX.getLogin());%></td>
			</tr>
			<tr>
				<td>You password</td>
				<td><% out.println(userX.getPassword());%></td>
			</tr>
			<tr>
				<td>You phone number</td>
				<td><% out.println(userX.getPhoneNumber());%></td>
			</tr>
			<tr>
				<td>Political View</td>
				<td><% out.println(userX.getPoliticalView()+ ", NOBODY loves him.");%></td>
			</tr>
		</tbody>
	</table>

</body>
</html>