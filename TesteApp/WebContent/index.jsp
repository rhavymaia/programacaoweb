<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" 
			content="text/html; charset=ISO-8859-1">
		<title>Meu título</title>
	</head>
	<body>		
		<c:forEach var="esporte" items="${esportes}">
			<h2>${esporte}</h2>
		</c:forEach>
	</body>
</html>