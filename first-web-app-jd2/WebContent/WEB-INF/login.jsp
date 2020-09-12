<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
		<h1>Okay, let's go login</h1>
		<form action="Controller" method="post">
		<input type="hidden" name="command" value="login" />
		Enter login: <br >
		<input type="text" name="login" value="" /><br >
		
		Enter password: <br >
		<input type="password" name="password" value="" /><br>
		<input type="submit" value="Complete" />
		</form>
		
</body>
</html>