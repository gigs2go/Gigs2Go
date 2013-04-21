<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="gigs2go" tagdir="/WEB-INF/tags"%>

<html lang="en">
<jsp:include page="../fragments/header.jsp" />
<body>
	<div class="container">
		<jsp:include page="../fragments/bodyHeader.jsp" />
		<!-- TODO - Get label from messageSource -->
		<c:choose>
			<c:when test="${venue['new']}">
				<c:set var="method" value="post" />
				<c:set var="action" value="add" />
				<c:set var="label" value="Add Venue" />
			</c:when>
			<c:otherwise>
				<c:set var="method" value="put" />
				<c:set var="action" value="update" />
				<c:set var="label" value="Update Venue" />
			</c:otherwise>
		</c:choose>
		<h2>${label}</h2>
		<form:form modelAttribute="venue" method="${method}"
			class="form-horizontal" id="venue-form">
			<fieldset>
				<gigs2go:inputField label="Name" name="name" />
				<gigs2go:inputField label="Town" name="address.town" />
				<gigs2go:inputField label="E-mail" name="email.value" />
				<input type="submit" class="button" name="_eventId_submit"
					value="${label}" />
			</fieldset>
		</form:form>
		<jsp:include page="../fragments/bodyFooter.jsp" />
	</div>
</body>