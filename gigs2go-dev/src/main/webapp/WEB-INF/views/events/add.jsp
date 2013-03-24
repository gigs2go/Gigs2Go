<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<form:form modelAttribute="event" action="add" method="post">
	<fieldset>
		<legend>Add Event</legend>
		<p>
			<form:errors
				cssStyle="margin-left: 0.5em; color: red; font-weight: bolder"
				path="artist" />
			<form:select path="artist">
				<form:option value="-1" label="--Please Select" />
				<form:options items="${artists}" itemValue="id" itemLabel="name" />
			</form:select>
		</p>
		<p>
			<form:errors
				cssStyle="margin-left: 0.5em; color: red; font-weight: bolder"
				path="venue" />
			<form:select path="venue">
				<form:option value="-1" label="--Please Select" />
				<form:options items="${venues}" itemValue="id" itemLabel="name" />
			</form:select>
		</p>
		<p>
			<form:button>Submit</form:button>
		</p>
	</fieldset>
</form:form>