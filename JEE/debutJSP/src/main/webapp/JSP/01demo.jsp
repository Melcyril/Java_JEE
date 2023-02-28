<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ include file="header.jsp"%>
<%
for(int i=0;i<10;i++){
String chaine ="hello";
%>
<p><%= chaine %> : <%= i+1 %></p>
<%}%>
</body>
</html>