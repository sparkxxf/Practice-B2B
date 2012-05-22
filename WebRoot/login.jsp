<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache,must-revalidate" />
<meta http-equiv="expires" content="0" />
<title><s:text name="login.pagetitle" /></title>
<link rel="stylesheet" type="text/css"
	href="<s:url value="/styles/green-serial.css" />" />
<script type="text/javascript" src="<s:url value='/scripts/login.js'/>">
</script>
<script type="text/javascript">

	var usnNotEmpty= "<s:text name='validate.usnNotEmpty' />";
	var pwdNotEmpty= "<s:text name='validate.pwdNotEmpty' />";
	var usnpwdNotEmpty= "<s:text name='validate.usnpwdNotEmpty' />";
	
</script>
</head>
<body>

<div class="login-cnt">

<div class="title"><s:text name="TLD E-B2B" /></div>

<div class="login-error-tip"><s:property value="loginErrorTips" />
</div>

<s:form name="login_form" action="loginAction_login" namespace="/login" >

	<table>
		<tr>
			<td class="td-right"><s:text name="user.name" /></td>
			<td class="td-left"><s:textfield id="userName" name="userName" />
			<img src="<s:url value='/images/login-name.gif'/>" /></td>
		</tr>

		<tr>
			<td class="td-right"><s:text name="user.password" /></td>
			<td class="td-left"><s:password id="password" name="password" />
			<img src="<s:url value='/images/login-lock.gif'/>" /></td>
		</tr>

	</table>

	<s:submit cssClass="btn" value="%{getText('btn.login')}"
		onclick="return formCheck()" />&nbsp;
	<s:reset cssClass="btn" value="%{getText('btn.reset')}" />

</s:form>
</div>

</body>
</html>