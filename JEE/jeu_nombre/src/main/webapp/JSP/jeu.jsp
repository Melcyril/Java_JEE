<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jeu</title>
</head>
<body>
<h1>Jeu</h1>
<% if(request.getAttribute("message")!=null){ %>
	<h2><%= request.getAttribute("message") %></h2>
<%} %>
<% if(request.getAttribute("gagne")==Boolean.TRUE){ %>
	<a href="<%= request.getContextPath() + "/initServlet" %>">Nouvelle partie</a>
	<% }else{ %>
<form method="POST" action="<%= request.getContextPath() %>/gameServlet">
<p> Choisir un nombre entre 1 et 100 <p>
<input type="number" name="choix" min="1" max="100">
<input type="submit">
</form>
<% } %>
</body>
</html>