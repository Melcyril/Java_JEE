<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Affichage</title>
</head>
<body>
	<h1>Pays dont la population est supèrieur à ${populationMin}</h1>
	<c:choose>
		<c:when test="${! empty pays }">
			<table>
				<thead>
					<tr>
						<th>Nom</th>
						<th>Continent</th>
						<th>Superficie</th>
						<th>Population</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${pays}" var="p">
						<tr>
							<td><c:out value="${p.nom}" /></td>

							<td><c:choose>
																<c:when test="${p.continent=='Asia' }">
							Asie
							</c:when>
									<c:when test="${p.continent=='Europe' }">
							Europe
							</c:when>
									<c:when test="${p.continent=='North America' }">
							Amérique du nord
							</c:when>
									<c:when test="${p.continent=='Africa' }">
							Afrique
							</c:when>
									<c:when test="${p.continent=='Oceania' }">
							Océanie
							</c:when>
									<c:when test="${p.continent=='Antartica' }">
							Antartique
							</c:when>
									<c:when test="${p.continent=='South America' }">
							Amérique du sud
							</c:when>
									<c:otherwise>
							Inconnu
							</c:otherwise>
								</c:choose></td>
							<fmt:setLocale value="fr_FR" />
							<td><fmt:formatNumber value="${p.superficie }"
									maxFractionDigits="0" /></td>
							<td><c:out value="${p.population}" />
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<h2>Pas de pays dans la liste</h2>
		</c:otherwise>
	</c:choose>

</body>
</html>