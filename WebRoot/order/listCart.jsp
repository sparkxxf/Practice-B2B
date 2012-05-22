<%@ include file="/commons/header.jsp"%>

<script type="text/javascript">
	var deleteOrderProductUrl = "<s:url action='orderAction_deleteOrderProduct' namespace='/order' includeParams='none' />";
	var toCreateUrl = 'orderAction_toCreate.action?deleteCartFlag=1';//"<s:url action='orderAction_toCreate' namespace='/order' includeParams='none' />";
	var do_putinAddressUrl = "<s:url action='orderAction_putinAddress' namespace='/order' includeParams='none' />";
	
	function do_delete() {
		if (!checkRadio("product.id")) {
			alert('Please select one');
			return;
		}
		var flag = confirm("are you sure delete?");
		if(flag) {
			document.query_form.action = deleteOrderProductUrl;
			document.query_form.submit();
			
		}
	}
	function do_addnew() {
		document.query_form.action = toCreateUrl;
		document.query_form.submit();
	}
	function do_putinAddress() {
		document.query_form.action = do_putinAddressUrl;
		document.query_form.submit();
	}
</script>

<div class="path-bar">
<s:text name="order.management" />-&nbsp;<s:text name="order.list.cart" /></div>

<s:form name="query_form" action="orderAction_deleteOrderProduct" namespace="/order">
<div class="content">

<s:fielderror />
	<s:hidden name="order.id" value="%{order.id}"></s:hidden><!-- while update order -->
	<!--<s:property value="order.id"/>-->
	
  	<input class='btn' type='button' name='add'
		value="<s:text name="btn.order.delete.product" />" onclick='do_delete();' />&nbsp;		
  	<input class='btn' type='button' name='update'
		value="<s:text name="btn.order.add.product" />" onclick='do_addnew();' />&nbsp;
  	<input class='btn' type='button' name='delete'
		value="<s:text name="btn.cart.tosave" />" onclick='do_putinAddress();' />&nbsp;

</div>


<div class="result">

	<div class="hint"><s:text name="user.query.result" /></div>

	<table width="" cellSpacing=0 border=1>
		<tr class="result-tr-th">
			<th></th>
			<th width="80"><s:text name="product.category.brand" /></th>
			<th width="80"><s:text name="product.category.type" /></th>
			<th width="200"><s:text name="product.category.desription" /></th>
			<th width="80"><s:text name="product.category.quantity" /></th>
			<th width="80"><s:text name="product.category.prize" /></th>
			<th width="200"><s:text name="product.category.remark" /></th>
			<th width="100"><s:text name="order.buy.count" /></th>
		</tr>
		<s:iterator value="#session.cart.values" status="index">
			<tr class="result-tr-td">
			  <td><input type="radio"  name="product.id" value="<s:property value="product.id" />" /></td>
			  <td><s:property value="product.brand" /></td>
			  <td><s:property value="product.type" /></td>
			  <td><s:property value="product.desc" /></td>
			  <td><s:property value="product.quan" /></td>
			  <td><s:property value="product.prize" /></td>
			  <td><s:property value="product.remark" /></td>
			  <td><s:property value="number" /></td>
			</tr>
		</s:iterator>
	</table>
</div>

</s:form>

<%@ include file="/commons/footer.jsp"%>


