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
				<c:set var="method" value="post" />
				<c:set var="action" value="add" />
				<c:set var="label" value="Register User" />
		<h2>${label}</h2>
		<form:form modelAttribute="user" method="${method}"
			class="form-horizontal" id="register-form" >
			<fieldset>
				<gigs2go:inputField label="Username" name="username" />
				<gigs2go:inputPasswordField label="Password" name="password" />
				<gigs2go:inputPasswordField label="Re-enter Password" name="checkPassword" />
				<button type="submit" formaction="../register/add">${label}</button>
			</fieldset>
		</form:form>
		<jsp:include page="../fragments/bodyFooter.jsp" />
	</div>
</body>
</html>