<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="gigs2go" tagdir="/WEB-INF/tags"%>

<html lang="en">
<jsp:include page="../fragments/header.jsp" />
<body>
	<jsp:include page="../fragments/bodyHeader.jsp" />
	<div class="container">
		<c:choose>
			<c:when test="${event['new']}">
				<c:set var="method" value="post" />
				<c:set var="action" value="add" />
				<c:set var="label" value="Add Event" />
			</c:when>
			<c:otherwise>
				<c:set var="method" value="put" />
				<c:set var="action" value="update" />
				<c:set var="label" value="Update Event" />
			</c:otherwise>
		</c:choose>
		<h2>${label}</h2>
		
		<form:form modelAttribute="event" method="${method}"
			class="form-horizontal" id="event-form">
			<fieldset>
				<gigs2go:inputSelect label="Artist" name="artist" list="${artists}" />
				<gigs2go:inputSelect label="Venue" name="venue" list="${venues}" />
				<p>
					<form:label path="date" cssErrorClass="error">Date</form:label>
					<br />
					<form:input id="datepicker" path="date" type="text"/>
					<form:errors path="date" />
				</p>
				<p>
					<button type="submit">${label}</button>
				</p>
			</fieldset>
		</form:form>
		<script>
			$(function() {
				$("#datepicker").datepicker({ minDate: "0", defaultDate: "+1", dateFormat: "yy/mm/dd (D, M dd)"
					});
			});
		</script>
		<jsp:include page="../fragments/bodyFooter.jsp" />
	</div>
</body>
</html>
