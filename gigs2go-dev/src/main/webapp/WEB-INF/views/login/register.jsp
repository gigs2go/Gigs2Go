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
		<c:set var="label" value="Register" />
		<h2>${label}</h2>
		<form:form commandName="register" modelAttribute="user" method="post" class="form-horizontal"
			id="register-form">
			<fieldset>
				<gigs2go:inputField label="Username" name="username" />
				<gigs2go:inputPasswordField label="Password" name="password" />
				<gigs2go:inputPasswordField label="Re-enter Password"
					name="checkPassword" />
				<gigs2go:inputRadio label="User Type" name="userType" items="<%= com.gigs2go.model.entities.security.UserType.values() %>"/>
				<div>
					<input type="submit" class="button" name="_eventId_submit" value="${label}"/>
				</div>
			</fieldset>
		</form:form>
		<jsp:include page="../fragments/bodyFooter.jsp" />
	</div>
</body>
</html>