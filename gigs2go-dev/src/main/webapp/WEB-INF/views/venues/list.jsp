<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="en">
<jsp:include page="../fragments/header.jsp" />
<body>
	<div class="container">
		<jsp:include page="../fragments/bodyHeader.jsp" />
		<table id="venues_table" class="gigs2goList" cellpadding="0"
			cellspacing="0" border="0" width="100%">
			<thead>
				<tr>
					<th>Venue Name</th>
					<th>E-Mail</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${venues}" var="venue">
					<tr>
						<spring:url value="/venues/{venueId}/update" var="venueUrl">
							<spring:param name="venueId" value="${venue.id}" />
						</spring:url>
						<td><a href="${fn:escapeXml(venueUrl)}">${venue.name}</a></td>
						<td>${venue.email.value}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<script charset="utf-8">
			$(document).ready(function() {
				$('#venues_table').dataTable({
					"sPaginationType" : "full_numbers",
					"oLanguage" : {
						"sLengthMenu" : "_MENU_ per page",
						"sSearch" : "Filter : _INPUT_",
						"sEmptyTable" : "No venues found"
					}
				});
			});
		</script>
		<jsp:include page="../fragments/bodyFooter.jsp" />
	</div>
</body>
</html>