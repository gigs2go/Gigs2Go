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
		<c:set var="label" value="Choose or Add Venue" />

		<h2>${label}</h2>
		<form method="post" class="form-horizontal" id="choose-venue-form">
			<fieldset>
				<gigs2go:inputSelect label="Venue" name="venue" list="${venues}" />
				<input type="submit" class="button" name="_eventId_submit"
					value="Choose" /> <input type="submit" class="button"
					name="_eventId_new" value="New" />
			</fieldset>
		</form>
		<jsp:include page="../fragments/bodyFooter.jsp" />
	</div>
</body>