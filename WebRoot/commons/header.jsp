<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache,must-revalidate" />
<meta http-equiv="expires" content="0" />
<title><s:text name="welcome.title" /></title> 
<link rel="stylesheet" type="text/css" href="<s:url value="/styles/green-serial.css" />" />
<link rel="stylesheet" type="text/css" href="<s:url value="/styles/green-menu.css" />" />
<script type="text/javascript" src="<s:url value='/scripts/common.js'/>"></script>
</head>
<body>

<div id="canvas">
<div id="ad"><s:text name="ad.banner.label" />
&nbsp;<br/>
<p style="font-size: 14px;text-align: middle">
welcome:&nbsp;<s:property value="#session.sessionUser.userName"/>
</p>
</div>
<div id="nav-bar">
	<%@ include file="menu_1.jsp" %>
</div>


<div class="main-content">
