<%@ include file="/commons/header.jsp"%>


<script type="text/javascript">
	var do_updateURL = "<s:url action='orderAction_updateOrder' namespace='/order' includeParams='none' />";
	
	function do_updateOrder() {	
		document.query_form.action = do_updateURL;
		document.query_form.submit();
	}
	
</script>

<div class="path-bar">
<s:text name="order.management" />-&nbsp;<s:text name="btn.order.view" />
</div>


<div class="content">

<s:form name="query_form" id="query_form"	action="orderAction_updateOrder" namespace="/order">
	<s:hidden value="%{order.id}" name="order.id"></s:hidden>
  	
	<table border="0" width="600px">
		<tr>
			<td class="td-right"><s:text name="people.name" /></td>
			<td class="td-left"><s:property  value="order.receivePeopleName"  /></td>
		</tr>
		<tr>
			<td class="td-right"><s:text name="people.address" /></td>
			<td class="td-left"><s:property
				value="order.address" /></td>
		</tr>
		<tr>
			<td class="td-right"><s:text name="people.post.code" /></td>
			<td class="td-left">
			<s:property  value="order.postCode"  /></td>
		</tr>
		<tr>
			<td class="td-right"><s:text name="people.call" /></td>
			<td class="td-left">
			<s:property  value="order.call"  /></td>
		</tr>
	</table>
	
	<input class='btn' type='button' name='edit'
		value="<s:text name="btn.order.update" />" onclick='do_updateOrder();' />&nbsp;
	<input class='btn' type='button' name='back'
		value="<s:text name="btn.back" />" onclick='window.history.back();' />&nbsp;
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
		
		<s:iterator value="order.itemSet">
			<tr class="result-tr-td">
				<td><s:property value="product.band" /></td>
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
