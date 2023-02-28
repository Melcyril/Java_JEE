<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Bienvenue</h1>
<form method="POST" action="<%= request.getContextPath() %>/initServlet">
	<fieldset>
		<legend>Niveau de difficulté</legend>
		<div>
			<input type="radio" id="100" name="difficulte" value="101" checked>
			<label for="100">1-100</label>
		</div>
		<div>
			<input type="radio" id="1000" name="difficulte" value="1001" checked>
			<label for="100">1-1000</label>
		</div>
			<div>
			<input type="radio" id="10000" name="difficulte" value="10001" checked>
			<label for="100">1-10000</label>
		</div>
	</fieldset>
	<input type="submit">
</form>
</body>
</html>