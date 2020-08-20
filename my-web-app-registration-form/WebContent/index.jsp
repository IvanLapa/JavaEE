<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Registration form</title>
</head>
<body>
	<h1>Registration new user</h1>
	<form action="myurl" method="post">
		<input type="hidden" name="command" value="forward" />
		Enter your first name:<br />
		<input type="text" name="First name" value="" /><br />
		Enter your login:<br />
		<input type="text" name="Login" value="" /><br />
		Enter your password:<br />
		<input type="password" name="Password" value="" /><br />
		Enter your phone number:<br />
		<input type="text" name="Number" value="" /><br />
		Do you love Lukashenko: YES/NO<br />
		<input type="text" name="Political View" value="" /><br />
	
		<input type="submit" value="SEND">
	</form>
</body>
</html>