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
		<c:set var="login_label" value="Login" />
		<c:set var="register_label" value="Register" />
		<h2>${login_label} Or ${register_label}</h2>

		<form:form modelAttribute="user" method="post"
			class="form-horizontal" id="register-form" >
			<fieldset>
				<gigs2go:inputField label="Username" name="username" />
				<gigs2go:inputPasswordField label="Password" name="password" />
			<div>
				<button type="submit" formaction="login_check" formmethod="post">${login_label}</button>
				&nbsp;Or&nbsp;
				<button type="submit" formaction="../register/new" formmethod="post">${register_label}</button>
			</div>
			</fieldset>
			</form:form>
		<!-- form class="form-horizontal" id="login-form">
			<div>
				Username&nbsp;<input name="j_username" type="text" required="required"/>
			</div>
			<div>
				Password&nbsp;<input name="j_password" type="password" required="required"/>
			</div>
			<div>
				<button type="submit" formaction="login_check" formmethod="post">${login_label}</button>
				&nbsp;Or&nbsp;
				<button type="submit" formaction="../register/new" formmethod="post">${register_label}</button>
			</div>
		</form -->

		<jsp:include page="../fragments/bodyFooter.jsp" />
	</div>
</body>
</html>