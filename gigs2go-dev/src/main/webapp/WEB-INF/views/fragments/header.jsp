<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><spring:message code="main.title"/>
</title>
	<spring:url value="http://yui.yahooapis.com/3.9.1/build/cssreset/reset-min.css" var="resetCss"/>
	<link href="${resetCss}" rel="stylesheet"/>

    <spring:url value="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" var="jQueryUICss"/>
    <link href="${jQueryUICss}" rel="stylesheet"/>

    <spring:url value="/resources/css/tables.css" var="tablesCss"/>
    <link href="${tablesCss}" rel="stylesheet"/>

    <spring:url value="/resources/css/bootstrap.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>

</head>


