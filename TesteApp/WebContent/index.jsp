<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" 
			content="text/html; charset=ISO-8859-1">
		<title>Pessoas</title>
	</head>
	<body>		
		<c:forEach var="pessoa" items="${pessoas}">
			<a href="BuscarUsuarioServlet?id=${pessoa.id}">
				<h2>${pessoa.nome}</h2>
			</a>
		</c:forEach>
	</body>
</html>