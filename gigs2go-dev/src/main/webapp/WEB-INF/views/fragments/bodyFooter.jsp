<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="navbar" style="width: 601px;">
	<div class="navbar-inner">
		<ul class="nav">
			<li><a href="<spring:url value="/" htmlEscape="true" />"><i
					class="icon-home"></i>Home</a></li>
			<li><a
				href="<spring:url value="/artists/add" htmlEscape="true" />"><i
					class="icon-plus-sign"></i>Add Artist</a></li>
			<li><a
				href="<spring:url value="/venues/add" htmlEscape="true" />"><i
					class="icon-plus-sign"></i>Add Venue</a></li>
			<li><a
				href="<spring:url value="/events/add" htmlEscape="true" />"><i
					class="icon-plus-sign"></i>Add Event</a></li>
		</ul>
	</div>
</div>
<div id="footer_image">
	<br/>
	<table class="footer">
		<tr>
			<td></td>
			<td align="right"><img
				src="<spring:url value="/resources/images/gigs2goLogo1.png" htmlEscape="true" />"
				alt="Powered by Spring" /></td>
		</tr>
	</table>
</div>


