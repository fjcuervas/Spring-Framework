<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="/WEB-INF/views/menu.jsp"></c:import>
	<h1>Index.jsp</h1>
	
	<a href='<c:url value="/about" />'>Acerca de</a> <br/>
	<a href='<c:url value="/admin" />'>Gestionar administradores</a> <br/>
	<a href='<c:url value="/rol" />'>Gestionar roles</a> <br/>
	
	<br/>
	<c:out value="${adminForm}" /> <br/>
</body>
</html>