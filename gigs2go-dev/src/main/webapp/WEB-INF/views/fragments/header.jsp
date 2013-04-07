<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><spring:message code="main.title"/>
</title>
	<spring:url value="http://yui.yahooapis.com/3.9.1/build/cssreset/reset-min.css" var="resetCss"/>
	<link href="${resetCss}" rel="stylesheet"/>

    <spring:url value="/webjars/bootstrap/2.3.1/css/bootstrap.min.css" var="bootstrapCss"/>
    <!-- spring:url value="/resources/css/bootstrap.css" var="bootstrapCss"/ -->
    <link href="${bootstrapCss}" rel="stylesheet"/>

    <spring:url value="/resources/css/gigs2go.css" var="gigs2goCss"/>
    <link href="${gigs2goCss}" rel="stylesheet"/>

    <spring:url value="/webjars/jquery/1.9.1/jquery.js" var="jQuery"/>
    <script src="${jQuery}"></script>

    <spring:url value="/webjars/jquery-ui/1.9.2/js/jquery-ui-1.9.2.custom.js" var="jQueryUi"/>
    <script src="${jQueryUi}"></script>

    <spring:url value="/webjars/jquery-ui/1.9.2/css/smoothness/jquery-ui-1.9.2.custom.css" var="jQueryUiCss"/>
    <link href="${jQueryUiCss}" rel="stylesheet"></link>

<!-- script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.9.1.js"></script -->
<!-- script
	src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.10.2/jquery-ui.js"></script -->
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.js"></script>
</head>


