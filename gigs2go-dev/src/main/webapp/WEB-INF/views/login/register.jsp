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
		<jsp:include page="../../content/register.jsp" />
		<c:set var="label" value="Register" />
		<h2>${label}</h2>
		<form:form commandName="register" modelAttribute="user" method="post" class="form-horizontal"
			id="register-form">
			<fieldset>
				<spring:message code="username.tooltip.text" var="usernameTooltip"/>
				<gigs2go:inputField label="E-Mail" name="username" title="${usernameTooltip}"/>
				<spring:message code="password.tooltip.text" var="passwordTooltip"/>
				<gigs2go:inputPasswordField label="Password" name="password" title="${passwordTooltip}"/>
				<spring:message code="check.password.tooltip.text" var="checkPasswordTooltip"/>
				<gigs2go:inputPasswordField label="Re-enter Password"
					name="checkPassword" title="${checkPasswordTooltip}"/>
				<spring:message code="usertype.tooltip.text" var="usertypeTooltip"/>
				<gigs2go:inputRadio label="User Type" name="userType" items="<%= com.gigs2go.model.entities.security.UserType.getRegisterTypes() %>" title="${usertypeTooltip}"/>
				<div>
					<input type="submit" class="button" name="_eventId_submit" value="${label}"/>
				</div>
			</fieldset>
		</form:form>
		<jsp:include page="../fragments/bodyFooter.jsp" />
	</div>
</body>
</html>