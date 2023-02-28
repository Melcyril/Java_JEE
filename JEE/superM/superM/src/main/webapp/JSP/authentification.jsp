<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="head.jsp"%>
</head>

<body>
<%@ include file="header.jsp"%>
<h1>Connexion</h1>
<form method="POST">
Login : <input type="text" name="username">
Mot de passe : <input type="password" name="password">
<input type="submit">
</form>
<!-- cdn javascipt de bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>