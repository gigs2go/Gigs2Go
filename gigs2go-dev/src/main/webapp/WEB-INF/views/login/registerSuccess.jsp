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
		<jsp:include page="../../content/registerSuccess.jsp" />
		<h2>Registration successful</h2>
		<p>Username : ${user.username}</p>
		<p>Password : *****</p>
		<form method="post">
			<input type="submit" class="button" name="_eventId_continue"
				value="Continue" />
		</form>
		<jsp:include page="../fragments/bodyFooter.jsp" />
	</div>
</body>
</html>