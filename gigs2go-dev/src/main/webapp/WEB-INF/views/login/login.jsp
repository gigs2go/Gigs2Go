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
		<c:choose>
			<c:when test="${fail}">
				<h2>Login Failed</h2>
				<c:set var="login_label" value="Try Again" />
			</c:when>
			<c:otherwise>
				<c:set var="login_label" value="Login" />
			</c:otherwise>
		</c:choose>
		<h2>${login_label}</h2>

		<form:form modelAttribute="user" method="post" class="form-horizontal"
			id="login-form">
			<fieldset>
				<spring:message code="username.tooltip.text" var="usernameTooltip"/>
				<gigs2go:inputField label="Username" name="username" title="${usernameTooltip}"/>
				<spring:message code="password.tooltip.text" var="passwordTooltip"/>
				<gigs2go:inputPasswordField label="Password" name="password" title="${passwordTooltip}"/>
				<div>
					<button type="submit" formaction="login_check">${login_label}</button>
				</div>
			</fieldset>
		</form:form>
		<jsp:include page="../fragments/bodyFooter.jsp" />
	</div>
</body>
</html>