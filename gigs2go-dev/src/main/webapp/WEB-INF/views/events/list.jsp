<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<jsp:include page="../fragments/header.jsp" />
<body>
	<jsp:include page="../fragments/bodyHeader.jsp" />
	<c:if test="${not empty events}">
		<table id="events_table">
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
		<br />
		<span>Nothing to display.</span>
	</c:if>
	<jsp:include page="../fragments/scriptsFooter.jsp" />
		<script>
			$(document).ready(function() {
				$('#events_table').dataTable({
					"sPaginationType" : "full_numbers"
				});
			});
		</script>
	<jsp:include page="../fragments/bodyFooter.jsp" />
</body>
</html>