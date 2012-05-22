<%@ include file="/commons/header.jsp"%>


<script type="text/javascript">
	
	function do_submitOder() {
	    var witch = document.getElementsByName("order.status")[1].checked;
	   	if(witch && document.getElementsByName("order.comment")[0].value == '') {
	   	   document.getElementById('test').innerHTML =  "comment is required!";
	   	   return false;
	   	}
	    document.approvl_form.submit();
	}
	
</script>

<div class="path-bar">
<s:text name="order.management" />-&nbsp;<s:text name="order.appr" />
</div>


<div class="content">

<s:form name="approvl_form" id="approvl_form"	action="orderAction_approvlOrder" namespace="/order">
	<s:hidden value="%{order.id}" name="order.id"></s:hidden>
	
	
	<table border="0" width="600px">
		<tr>
			<td class="td-right"><s:text name="order.appr.sel" /></td>
			<td class="td-left">
				<input type="radio" name="order.status" value="2"/><s:text name="order.appr.yes" />&nbsp;
				<input type="radio" name="order.status" value="3" checked="checked"/><s:text name="order.appr.no" />
			</td>
		</tr>
		<tr>
			<td class="td-right"><s:text name="order.appr.comment" /></td>
			<td class="td-left"><s:textarea name="order.comment" cols="50" rows="2" /><font color="red"><span id='test'></span></font></td>
		</tr>
		
	</table>
	<s:if test="user.enabled_approval==1">
		<input class='btn' type='button' name='submit1'
			value="<s:text name="order.submit.approval" />" onclick='do_submitOder();' />&nbsp;
	</s:if>
	<s:else>
		<font color="red"><s:text name="order.manager.cannot.approvl" /></font>
	</s:else>
	<input class='btn' type='button' name='back'
		value="<s:text name="btn.back" />" onclick='do_backTocreate();' />&nbsp;
  	
		
	<table border="0" width="600px">
		<tr>
			<td class="td-right"><s:text name="people.name" />:</td>
			<td class="td-left"><s:property  value="order.receivePeopleName"  /></td>
		</tr>
		<tr>
			<td class="td-right"><s:text name="people.address" />:</td>
			<td class="td-left"><s:property  value="order.address" /></td>
		</tr>
		<tr>
			<td class="td-right"><s:text name="people.post.code" />:</td>
			<td class="td-left">
			<s:property  value="order.postCode"  /></td>
		</tr>
		<tr>
			<td class="td-right"><s:text name="people.call" />:</td>
			<td class="td-left">
			<s:property  value="order.call"  /></td>
		</tr>
	</table>
	
</s:form>

</div>

<div class="result">
	<div class="hint">
		<s:text name="order.detail" />
	</div>

	<table width="600px" cellSpacing=0 border=1>
		<tr class="result-tr-th">
			
			<th width="50"><s:text name="product.name" /></th>
			<th width="50"><s:text name="product.type" /></th>
			<th width="80"><s:text name="product.price" /></th>
			<th width="80"><s:text name="cart.count" /></th>
		</tr>
		
		<s:iterator value="order.itemSet" status="index">
			<tr class="result-tr-td">
				<td><s:property value="product.brand" /></td>
				<td><s:property value="product.productType.name" /></td>
				<td><s:property value="product.prize" /></td>
				<td>
				    <s:property value="number" />
				</td>
			</tr>
		</s:iterator>
	</table>
</div>

<%@ include file="/commons/footer.jsp"%>
