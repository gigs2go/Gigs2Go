<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<jsp:include page="../fragments/header.jsp" />
<body>
	<jsp:include page="../fragments/bodyHeader.jsp" />
	<c:if test="${not empty venues}">
		<table id="venues_table">
			<thead>
				<tr>
					<td>Venue Name</td>
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
		<br />
		<span>Nothing to display.</span>
	</c:if>
	<jsp:include page="../fragments/scriptsFooter.jsp" />
		<script>
			$(document).ready(function() {
				$('#venues_table').dataTable({
					"sPaginationType" : "full_numbers"
				});
			});
		</script>
	<jsp:include page="../fragments/bodyFooter.jsp" />
</body>
</html>