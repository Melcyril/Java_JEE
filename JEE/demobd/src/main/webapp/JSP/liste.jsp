<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList,com.example.Pays" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Bienvenue ${prenom}</h1>
	<ul>
	<% for(Pays p :((ArrayList<Pays>)request.getAttribute("pays"))){ %>
		<li><%= p.getNom() %> - <%= p.getPopulation() %></li>
	</ul>
	 <% } %>
</body>
</html>