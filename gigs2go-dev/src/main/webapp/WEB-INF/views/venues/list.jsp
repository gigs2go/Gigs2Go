<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Gigs2Go Project</title>
</head>
<body>
	<c:if test="${not empty venues}">
		<table>
			<thead>
				<tr>
					<td>Name</td>
					<td>Town</td>
					<td>E-Mail</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${venues}" var="venue">
					<tr>
						<td>${venue.name}</td>
						<td>${venue.address.town}</td>
						<td>${venue.email.value}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<c:if test="${empty venues}">
		<br />
		<span>Nothing to display.</span>
	</c:if>
</body>
</html>