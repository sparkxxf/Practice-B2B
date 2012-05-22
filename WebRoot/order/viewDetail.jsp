<%@ include file="/commons/header.jsp"%>


<script type="text/javascript">
	var do_submitURL = "<s:url action='orderAction_submit' namespace='/order' includeParams='none' />";
	var do_backTocreateURL = "<s:url action='orderAction_toCreate' namespace='/order' includeParams='none' />";

	
	function do_submitOrder() {	
	
		document.query_form.action = do_submitURL;
		document.query_form.submit();
	}
	
	function do_backTocreate() {
		document.query_form.action = do_backTocreateURL;
		document.query_form.submit();
	}
	
</script>

<div class="path-bar">
<s:text name="order.management" />-&nbsp;<s:text name="order.view.order" />
</div>


<div class="content">

<s:form name="query_form" id="query_form" action="orderAction_submit" namespace="/order">
	<s:hidden value="%{order.id}"  name="order.id"></s:hidden>
	
	<input class='btn' type='button' name='submitee' value="<s:text name="btn.order.sumit" />" onclick='do_submitOrder();' />&nbsp;
	<input class='btn' type='button' name='back'
		value="<s:text name="btn.back" />" onclick='do_backTocreate();' />&nbsp;
  	
		
	<table border="0" width="600px">
		<tr>
			<td class="td-right"><s:text name="people.name" /></td>
			<td class="td-left"><s:property  value="order.receivePeopleName"  /></td>
		</tr>
		<tr>
			<td class="td-right"><s:text name="people.address" /></td>
			<td class="td-left"><s:property  value="order.address" /></td>
		</tr>
		<tr>
			<td class="td-right"><s:text name="people.post.code" /></td>
			<td class="td-left"><s:property  value="order.postCode"  /></td>
		</tr>
		<tr>
			<td class="td-right"><s:text name="people.call" /></td>
			<td class="td-left"><s:property  value="order.call"  /></td>
		</tr>
	</table>
	
</s:form>

</div>

<div class="result">
	<div class="hint">
		<s:text name="btn.cart" />
	</div>

	<table width="600px" cellSpacing=0 border=1>
		<tr class="result-tr-th">
			
			<th width="100"><s:text name="product.name" /></th>
			<th width="100"><s:text name="product.type" /></th>
			<th width="100"><s:text name="product.price" /></th>
			<th width="100"><s:text name="cart.count" /></th>
		</tr>
		
		<s:iterator value="order.itemSet" status="index">
			<tr class="result-tr-td">
				<td><s:property value="product.type" /></td>
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
