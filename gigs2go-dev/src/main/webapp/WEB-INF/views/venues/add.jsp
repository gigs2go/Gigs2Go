<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html lang="en">
<jsp:include page="../fragments/header.jsp"/>
<body>
<form:form modelAttribute="venue" action="add" method="post">
	<fieldset>
		<legend>Add Venue</legend>
		<p>
			<form:label path="name" cssErrorClass="error">Name</form:label><br />
			<form:input path="name" /><form:errors cssStyle="margin-left: 0.5em; color: red; font-weight: bolder" path="name" />
		<p>
			<form:label path="email.value" cssErrorClass="error">E-mail</form:label><br />
			<form:input path="email.value" type="email"/><form:errors cssStyle="margin-left: 0.5em; color: red; font-weight: bolder" path="email.value" />
		</p>
		<p>
			<form:label path="address.town" cssErrorClass="error">Town</form:label><br />
			<form:input path="address.town"/><form:errors cssStyle="margin-left: 0.5em; color: red; font-weight: bolder" path="address.town" />
		</p>
		<p>
			<form:button>Submit</form:button>
		</p>
	</fieldset>
</form:form>
<jsp:include page="../fragments/scriptsFooter.jsp"/>
<jsp:include page="../fragments/bodyFooter.jsp"/>
</body>