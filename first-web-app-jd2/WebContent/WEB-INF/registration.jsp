<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
		<h1>Okay, let's go registration</h1>
		<form action="Controller" method="post">
		<input type="hidden" name="command" value="registration" />
		Enter name: <br>
		<input type="text" name="name" value="" /><br>
		Enter surname: <br>
		<input type="text" name="surname" value="" /><br>
		Enter login: <br>
		<input type="text" name="login" value="" /><br>
		Enter password: <br>
		<input type="password" name="password" value="" /><br>
		<input type="submit" value="Complete" />
		</form>
</body>
</html>