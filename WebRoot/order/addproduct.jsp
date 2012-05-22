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

<div class="main-content">

<script type="text/javascript">
    /*var errormsg = "<s:text name='order.enter.number' />";*/
    var errormsg = "请输入购买产品的数量";
	function formCheck() {
		var count = document.getElementById("p_count").value;
		if (!/^[1-9]\d*$/.test(count)) {
			alert(errormsg);
			return;
		}
		document.add_form.submit();
	}
</script>


<div class="path-bar"></div>

<div class="content">

<s:fielderror />
<s:hidden name="order.id" value="%{order.id}"></s:hidden><!-- while update order -->
<!--<s:property value="order.id"/>-->
<s:hidden value="%{product.id}" name="product.id"></s:hidden>
<!--<s:property value="product.id"/>-->

<s:form name="add_form"	action="orderAction_buy" namespace="/order">
	<s:hidden name="product.id" value="%{product.id}"></s:hidden>
	<table border="0" width="600px">
		<tr>
			<td class="td-right"><s:text name="pType.name" /></td>
			<td class="td-left">
			    <s:property value="product.productType.name"/>
			</td>
			<td class="td-right"><s:text name="product.category.band" /></td>
			<td class="td-left"><s:property value="product.band"/></td>
		</tr>
		<tr>
		    <td class="td-right"><s:text name="product.category.type" /></td>
			<td class="td-left"><s:property value="product.type" /></td>
		    <td class="td-right"><s:text name="product.category.prize" /></td>
			<td class="td-left"><s:property value="product.prize" /></td>
		</tr>
		<tr>
		    <td class="td-right"><s:text name="product.category.quantity" /></td>
			<td class="td-left"><s:property value="product.quan" /></td>
		    <td class="td-right"><s:text name="product.category.desription" /></td>
			<td class="td-left"><s:property value="product.desc" /></td>
		</tr>
		<tr>
		    <td class="td-right"><s:text name="cart.count" /></td>
			<td class="td-left"><s:textfield name="p_count" id="p_count"></s:textfield></td>
		    
		</tr>
	</table>
	<input type="button" class="btn" value="<s:text name="btn.submit" />" onclick="formCheck()" />&nbsp;
	<s:reset cssClass="btn" value="%{getText('btn.reset')}" />&nbsp;
  	
</s:form>

</div>

<%@ include file="/commons/footer.jsp"%>
