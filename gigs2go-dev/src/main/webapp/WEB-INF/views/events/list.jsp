<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Spring-Data MVC Project</title>
	</head>
	<body>
		<c:if test="${not empty events}">
		<table>
			<thead>
				<tr>
					<td>Artist</td>
					<td>Venue</td>
					<td>Town</td>
					<td>Date</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${events}" var="event">
					<tr>
						<td>${event.artist.name}</td>
						<td>${event.venue.name}</td>
						<td>${event.venue.address.town}</td>
						<td>${event.dayt}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:if>
		<c:if test="${empty events}">
		<br /><span>Nothing to display.</span>
		</c:if>
	</body>
</html>