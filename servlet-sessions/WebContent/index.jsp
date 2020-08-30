<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Session</title>
</head>
<body>
	<br />
	<c:if test="${requestScope.encodeURL == null}">
		<c:set var="encodeURL" scope="request" value="Controller" />
	</c:if>

	<form action="${requestScope.encodeURL}" method="post">
		<!-- <input type="text" name="paramname" value="" /> <br /> <input
			type="text" name="paramvalue" value="" /> <br />  --><input
			type="submit" value="send next HttpRequest" /><br />
	</form>
	
	<c:out value="${requestScope.encodeURL}"  />
</body>
</html>