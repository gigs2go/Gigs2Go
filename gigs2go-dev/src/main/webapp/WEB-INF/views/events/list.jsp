<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="en">
<jsp:include page="../fragments/header.jsp" />
<body>
	<div class="container">
		<jsp:include page="../fragments/bodyHeader.jsp" />
		<table id="events_table" class="gigs2goList">
			<thead>
				<tr>
					<th>Artist</th>
					<th>Venue</th>
					<th>Town</th>
					<th>Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${events}" var="event">
					<tr>
						<td>${event.artist.name}</td>
						<td>${event.venue.name}</td>
						<td>${event.venue.address.town}</td>
						<td><spring:eval expression="event.date" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<script>
			$(document).ready(function() {
				$('#events_table').dataTable({
					"sPaginationType" : "full_numbers",
					"oLanguage" : {
						"sLengthMenu" : "_MENU_ per page",
						"sSearch" : "Filter : _INPUT_",
						"sEmptyTable" : "No events found"
					}
				});
			});
		</script>
		<jsp:include page="../fragments/bodyFooter.jsp" />
	</div>
</body>
</html>