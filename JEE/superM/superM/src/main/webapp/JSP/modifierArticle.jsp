<%@page import="com.cp.Article"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList,com.cp.Article"%>

 
<!DOCTYPE html>
 
<html>
<head>
<%@ include file="head.jsp"%>
</head>

<body>
<%@ include file="header.jsp"%>
<div class="container">	
	<table>
		<thead>
		<tr>
			<th>Code barre</th>
			<th>Reference</th>
			<th>Libellé</th>
			<th>Prix HT</th>
			<th>Tva</th>
			<th>Ajouter le panier</th>
		</tr>
		</thead>
		<tbody>
		

		<% for(Article p :((ArrayList<Article>)session.getAttribute("article"))){ %>
		<tr>
			<td><%= p.getCodebarre() %></td>
			<td><%= p.getReference() %></td>
			<td><%= p.getLibelle() %></td>
			<td><%=p.getPrixHT() %></td>
			<td><%= p.getTVA() %></td>
			<td><a>Ajouter au panier</a></td>
		</tr>
	 	<% } %>
	 	
	 	</tbody>
	</table>
</div>
<h1>Modifier un article</h1>
<form method="POST">
<input type="number" name="code" placeholder="Code barre">
<input type="text" name="ref" placeholder="Reference">
<input type="text" name="lib" placeholder="libelle">
<input type="number" name="prixht" placeholder="PrixHT">
<input type="number" name ="tva" min=0 max=1 placeholder="Indice Tva(0->550,1->2000)">
<input type="submit">
</form>

<!-- cdn javascipt de bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>