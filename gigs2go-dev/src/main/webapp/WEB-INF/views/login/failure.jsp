<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<jsp:include page="../WEB-INF/views/fragments/header.jsp" />
<body>
	<div class="container">
		<jsp:include page="../WEB-INF/views/fragments/bodyHeader.jsp" />
		<c:set var="label1" value="Login Failed" />
		<c:set var="label2" value="Try Again" />
		<h2>${label1}</h2>

		<form action="login_check" method="post" class="form-horizontal"
			id="login-form">
				<div>Username&nbsp;<input name="j_username" type="text" /></div>
				<div>Password&nbsp;<input name="j_password" type="password"/></div>
				<div><button type="submit">${label2}</button></div>
		</form>

		<jsp:include page="../WEB-INF/views/fragments/bodyFooter.jsp" />
	</div>
</body>
</html>