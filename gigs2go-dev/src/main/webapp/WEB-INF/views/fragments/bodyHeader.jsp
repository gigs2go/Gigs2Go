<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<spring:url value="/resources/images/Mountains.png" var="banner" />
<img src="${banner}" width="100%"/>

<div class="navbar" style="width: 100%;">
	<div class="navbar-inner">
		<ul class="nav">
			<li><a href="<spring:url value="/" htmlEscape="true" />"><i
					class="icon-home"></i>Home</a></li>
			<li><a
				href="<spring:url value="/artists" htmlEscape="true" />"><i
					class="icon-th-list"></i>List Artists</a></li>
			<li><a
				href="<spring:url value="/venues" htmlEscape="true" />"><i
					class="icon-th-list"></i>List Venues</a></li>
			<li><a
				href="<spring:url value="/events" htmlEscape="true" />"><i
					class="icon-th-list"></i>List Events</a></li>
			<sec:authorize access="isAuthenticated()">
			<li><a
				href="<spring:url value="/logout" htmlEscape="true" />"><i
					class="icon-thumbs-down"></i>Logout</a></li>
					</sec:authorize>
			<sec:authorize access="isAnonymous()">
			<li><a
				href="<spring:url value="/login/login" htmlEscape="true" />"><i
					class="icon-thumbs-up"></i>Login</a></li>
					</sec:authorize>
			<sec:authorize access="isAnonymous()">
			<li><a
				href="<spring:url value="/register" htmlEscape="true" />"><i
					class="icon-thumbs-up"></i>Register</a></li>
					</sec:authorize>
		</ul>
	</div>
</div>

