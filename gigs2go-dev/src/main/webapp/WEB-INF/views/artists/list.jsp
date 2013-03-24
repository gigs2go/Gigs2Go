<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Gigs2Go Project</title>
	</head>
	<body>
		<c:if test="${not empty artists}">
		<table>
			<thead>
				<tr>
					<td>Name</td>
					<td>E-Mail</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${artists}" var="artist">
					<tr>
						<td>${artist.name}</td>
						<td>${artist.email.value}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:if>
		<c:if test="${empty artists}">
		<br /><span>Nothing to display.</span>
		</c:if>
	</body>
</html>