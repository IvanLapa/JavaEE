<%@ page language="java" import="by.htp.les02.entity.User" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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