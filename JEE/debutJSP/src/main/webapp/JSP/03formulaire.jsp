<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulaire</title>
</head>
<body>
<form method="POST">
<p>
	Ton nom :
	<input type="text" name="nom">
</p>
<p>
	Ton age :
	<input type="number" name="age" min="0" max="150">
</p>
<p>
	<input type="submit">
</p>
</form>
</body>
</html>