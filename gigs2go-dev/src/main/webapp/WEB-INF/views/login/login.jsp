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
		<c:set var="register_label" value="Register" />
		<c:choose>
			<c:when test="${fail}">
				<h2>Login Failed</h2>
				<c:set var="login_label" value="Try Again" />
			</c:when>
			<c:otherwise>
				<c:set var="login_label" value="Login" />
			</c:otherwise>
		</c:choose>
		<h2>${login_label} Or ${register_label}</h2>

		<form:form modelAttribute="user" method="post" class="form-horizontal"
			id="login-form">
			<fieldset>
				<gigs2go:inputField label="Username" name="username" />
				<gigs2go:inputPasswordField label="Password" name="password" />
				<div>
					<button type="submit" formaction="login_check">${login_label}</button>
					&nbsp;Or&nbsp;
					<button type="submit" formaction="../register/new">${register_label}</button>
				</div>
			</fieldset>
		</form:form>
		<jsp:include page="../fragments/bodyFooter.jsp" />
	</div>
</body>
</html>