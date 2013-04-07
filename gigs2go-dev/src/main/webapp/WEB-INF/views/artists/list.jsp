<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="en">
<jsp:include page="../fragments/header.jsp" />
<body>
	<div class="container">
		<jsp:include page="../fragments/bodyHeader.jsp" />
		<table id="artists_table" class="gigs2goList">
			<thead>
				<tr>
					<th>Artist Name</th>
					<th>E-Mail</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${artists}" var="artist">
					<tr>
						<spring:url value="/artists/{artistId}/update" var="artistUrl">
							<spring:param name="artistId" value="${artist.id}" />
						</spring:url>
						<td><a href="${fn:escapeXml(artistUrl)}">${artist.name}</a></td>
						<td>${artist.email.value}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<script charset="utf-8">
			$(document).ready(function() {
				$('#artists_table').dataTable({
					"sPaginationType" : "full_numbers",
					"oLanguage" : {
						"sLengthMenu" : "_MENU_ per page",
						"sSearch" : "Filter : _INPUT_",
						"sEmptyTable" : "No artists found"
					}
				});
			});
		</script>
		<jsp:include page="../fragments/bodyFooter.jsp" />
	</div>
</body>
</html>