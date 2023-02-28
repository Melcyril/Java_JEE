<%@page import="com.cp.Article"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList,com.cp.Article"%>

 <%
 if(request.getParameter("index")!=null) {
	   
	   ArrayList<String> panier = (ArrayList<String>) request.getAttribute("index");
	  // System.out.println(request.getParameter("index"));
	   String stock="";
	   if(session.getAttribute("panier")!=null){
	   		stock= stock=session.getAttribute("panier")+ request.getParameter("index");
	   		stock= stock+"/";
	   }else{
		   stock= stock=request.getParameter("index");
		   stock= stock+"/";
	   }
	   session.setAttribute("panier",stock);
	   System.out.println(session.getAttribute("panier"));
}
 %>
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

			<td><a href="<%= request.getContextPath() %>/JSP/index.jsp?index=<%=p.getCodebarre() %>">Ajouter au panier</a></form></td>
		</tr>
	 	<% } %>
	 	
	 	</tbody>
	</table>
</div>
<!-- cdn javascipt de bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>