<%@ tag body-content="empty" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="name" required="true" rtexprvalue="true"
              description="Name of corresponding property in bean object" %>
<%@ attribute name="label" required="true" rtexprvalue="true"
              description="Label appears in red color if input is considered as invalid after submission" %>
<%@ attribute name="list" required="true" rtexprvalue="true" type="java.util.List"
              description="The list of objects from which one must be chosen" %>

<spring:bind path="${name}">
    <c:set var="cssGroup" value="control-group ${status.error ? 'error' : '' }"/>
    <div class="${cssGroup}">
        <label class="control-label">${label}</label>

        <div class="controls">
					<form:select name="id" path="${name}" >
						<form:options items="${list}" itemLabel="name" itemValue="id" />
					</form:select>
            <span class="help-inline">${status.errorMessage}</span>
        </div>
    </div>
</spring:bind>
</tag>
