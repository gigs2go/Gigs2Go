<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<jsp:include page="../fragments/header.jsp" />
<body>
	<div class="container">
		<jsp:include page="../fragments/bodyHeader.jsp" />
		<c:if test="${not empty artists}">
			<table id="artists_table" class="artists" cellpadding="0"
				cellspacing="0" border="0" width="100%">
				<thead>
					<tr>
						<th>Artist Name</th>
						<th>E-Mail</th>
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
				<tfoot>
					<tr>
						<th>Artist Name</th>
						<th>E-Mail</th>
					</tr>
				</tfoot>
			</table>
		</c:if>
		<c:if test="${empty artists}">
			<br />
			<span>Nothing to display.</span>
		</c:if>
		<jsp:include page="../fragments/scriptsFooter.jsp" />
		<script charset="utf-8">
			$(document).ready(function() {
				$('#artists_table').dataTable({
					"sPaginationType" : "full_numbers"
				});
			});
		</script>
		<jsp:include page="../fragments/bodyFooter.jsp" />
	</div>
</body>
</html>