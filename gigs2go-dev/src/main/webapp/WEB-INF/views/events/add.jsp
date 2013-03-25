<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<form:form modelAttribute="venue" action="add" method="post">
	<fieldset>
		<legend>Add Event</legend>
		<p>
			<form:label path="artist.name" cssErrorClass="error">Artist</form:label><br />
			<form:input path="artist.name" /><form:errors cssStyle="margin-left: 0.5em; color: red; font-weight: bolder" path="artist.name" />
		</p>
		<p>
			<form:label path="venue.name" cssErrorClass="error">Venue</form:label><br />
			<form:input path="venue.name"/><form:errors cssStyle="margin-left: 0.5em; color: red; font-weight: bolder" path="venue.name" />
		</p>
		<p>
			<form:label path="dayt" cssErrorClass="error">Date</form:label><br />
			<form:input path="dayt" type="date"/><form:errors cssStyle="margin-left: 0.5em; color: red; font-weight: bolder" path="dayt" />
		</p>
		<p>
			<form:button>Submit</form:button>
		</p>
	</fieldset>
</form:form>