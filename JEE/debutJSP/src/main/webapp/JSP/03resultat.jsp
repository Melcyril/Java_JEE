<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="nomMaj" scope="request" type="java.lang.String" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@  include file="header.jsp" %>
	<jsp:useBean id="ageM" scope="request" type="java.lang.Integer" />
	<p>Ton nom : <%= nomMaj %><p>
	<p>Ton age : <%= ageM %></p>
</body>
</html>