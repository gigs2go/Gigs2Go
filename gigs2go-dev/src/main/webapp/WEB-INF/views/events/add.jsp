<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html lang="en">
<jsp:include page="../fragments/header.jsp"/>
<body>
<form:form modelAttribute="event" action="add" method="post">
	<fieldset>
		<legend>Add Event</legend>
		<p>
			<form:label path="artist" cssErrorClass="error">Artist</form:label>
			<br />
			<form:select path="artist">
				<form:options items="${artists}" itemLabel="name" itemValue="id" />
			</form:select>
		</p>
		<p>
			<form:label path="venue" cssErrorClass="error">Venue</form:label>
			<br />
			<form:select path="venue">
				<form:options items="${venues}" itemLabel="name" itemValue="id" />
			</form:select>
		</p>
		</p>
		<p>
			<form:label path="dayt" cssErrorClass="error">Date</form:label>
			<br />
			<form:input id="datepicker" path="dayt" type="text" />
			<form:errors path="dayt" />
		</p>
		<p>
			<form:button>Submit</form:button>
		</p>
	</fieldset>
</form:form>
<jsp:include page="../fragments/scriptsFooter.jsp"/>
<script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
  </script>
<jsp:include page="../fragments/bodyFooter.jsp"/>
</body>
</html>
