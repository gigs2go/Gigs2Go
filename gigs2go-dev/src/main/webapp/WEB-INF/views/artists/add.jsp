<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<form:form modelAttribute="artist" action="add" method="post">
	<fieldset>
		<legend>Add Artist</legend>
		<p>
			<form:label path="name" cssErrorClass="error">Name</form:label><br />
			<form:input path="name" /><form:errors cssStyle="margin-left: 0.5em; color: red; font-weight: bolder" path="name" />
		</p>
		<p>
			<form:label path="email" cssErrorClass="error">E-Mail</form:label><br />
			<form:input path="email"/><form:errors cssStyle="margin-left: 0.5em; color: red; font-weight: bolder" path="email" />
		</p>
		<p>
			<form:button>Submit</form:button>
		</p>
	</fieldset>
</form:form>