<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<spring:url value="/resources/images/gigs2goImg1.png" var="banner" />
<img src="${banner}" />

<div class="navbar" style="width: 601px;">
	<div class="navbar-inner">
		<ul class="nav">
			<li><a href="<spring:url value="/" htmlEscape="true" />"><i
					class="icon-home"></i>Home</a></li>
			<li><a
				href="<spring:url value="/artists/list" htmlEscape="true" />"><i
					class="icon-search"></i>List Artists</a></li>
			<li><a
				href="<spring:url value="/venues/list" htmlEscape="true" />"><i
					class="icon-th-list"></i>List Venues</a></li>
			<li><a
				href="<spring:url value="/events/list" htmlEscape="true" />"><i
					class="icon-th-list"></i>List Events</a></li>
		</ul>
	</div>
</div>

