<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <jsp:useBean id="naming" class="_java._ee._02._servlet.SimpleBean" />
	
	<jsp:setProperty property="*" name="naming"/>
	
	<jsp:getProperty property="name" name="naming"/>	
	<jsp:getProperty property="surname" name="naming"/>
	<jsp:getProperty property="date" name="naming"/>
	
	<jsp:useBean id="pageDate" class="java.util.Date" />
	
	<jsp:setProperty name="naming" property="date" value="${pageDate}" />
	<jsp:getProperty property="date" name="naming"/>
	
	<c:out value="${pageScope.naming.name}" />	

</body>
</html>