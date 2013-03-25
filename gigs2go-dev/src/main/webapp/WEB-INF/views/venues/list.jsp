<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Spring-Data MVC Project</title>
	</head>
	<body>
		<c:if test="${not empty venues}">
		<table>
			<thead>
				<tr>
					<td>Name</td>
					<td>E-Mail</td>
					<td>Town</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${venues}" var="venue">
					<tr>
						<td>${venue.name}</td>
						<td>${venue.email.value}</td>
						<td>${venue.address.town}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:if>
		<c:if test="${empty venues}">
		<br /><span>Nothing to display.</span>
		</c:if>
	</body>
</html>