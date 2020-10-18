<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
		<h1>Hello User!</h1>
		Select what you want to do :)</br >
		
		<form action="goToTransferServlet" method="post">
		<input type="hidden" name="command" value="login" />
		<input type="submit" value="login" />
		</form>
		<br>
		<form action="goToTransferServlet" method="post">
		<input type="hidden" name="command" value="registration" />
		<input type="submit" value="registration" />
		</form>
</body>
</html>