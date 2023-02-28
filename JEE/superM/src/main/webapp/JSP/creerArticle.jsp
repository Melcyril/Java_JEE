<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="head.jsp"%>
</head>

<body>
<%@ include file="header.jsp"%>


<h1>Créer un article</h1>
<form method="POST">
<input type="number" name="code" placeholder="Code barre">
<input type="text" name="ref" placeholder="Reference">
<input type="text" name="lib" placeholder="libelle">
<input type="number" name="prixht" placeholder="PrixHT">
<input type="number" name ="tva" min=0 max=1 placeholder="Indice Tva(0->550,1->2000)">
<input type="submit">
</form>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>