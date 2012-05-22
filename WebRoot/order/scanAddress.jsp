<%@ include file="/commons/header.jsp"%>


<script type="text/javascript">
	var do_backTocreateURL = "<s:url action='orderAction_toCreate' namespace='/order' includeParams='none' />";
	
	function do_back(){
		document.address_form.action = do_backTocreateURL;
		document.address_form.submit();
	}
	
	function toView() {
		var name = document.getElementById('order.receivePeopleName').value;
		if (name.length == 0) {
			alert("please enter receive person's real name");
			return;
		}
		var address = document.getElementById('order.address').value;
		if (address.length == 0) {
			alert("please enter receive address");
			return;
		}
		document.address_form.submit();
	}
</script>

<div class="path-bar">
<s:text name="order.management" />-&nbsp;<s:text name="order.put.address" />
</div>

<div class="result">
	<div class="hint">
		<s:text name="btn.cart" />
	</div>

	<!--<s:property value="order.id"/>-->
	<s:hidden value="%{product.id}" name="product.id"></s:hidden>
	<!--<s:property value="product.id"/>-->
	
	<table width="" cellSpacing=0 border=1>
		<tr class="result-tr-th">
			
			<th width="100"><s:text name="product.name" /></th>
			<th width="100"><s:text name="product.type" /></th>
			<th width="100"><s:text name="product.price" /></th>
			<th width="100"><s:text name="cart.count" /></th>
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

<div class="content">

<s:fielderror />





<s:form name="address_form"	action="orderAction_toView" namespace="/order">
	<s:hidden name="order.id" value="%{order.id}"></s:hidden><!-- while update order -->
	
	
	<table border="0" width="600px">
		<tr>
			<td class="td-right"><s:text name="people.name" /></td>
			<td class="td-left"><s:textfield id="order.receivePeopleName" name="order.receivePeopleName" maxlength="10" /><font
				style="color: red;">*</font></td>
		</tr>
		<tr>
			<td class="td-right"><s:text name="people.address" /></td>
			<td class="td-left"><s:textarea
				name="order.address" cols="50" rows="2" /><font
				style="color: red;">*</font></td>
		</tr>
		<tr>
			<td class="td-right"><s:text name="people.post.code" /></td>
			<td class="td-left">
			<s:textfield id="order.postCode" name="order.postCode" maxlength="10" /></td>
		</tr>
		<tr>
			<td class="td-right"><s:text name="people.call" /></td>
			<td class="td-left">
			<s:textfield id="order.call" name="order.call" maxlength="20" /></td>
		</tr>
	</table>
	
	<input class='btn' type='button' name='back'
		value="<s:text name="btn.order.view" />" onclick='toView();' />&nbsp;
	<s:reset cssClass="btn" value="%{getText('btn.reset')}" />&nbsp;
  	<input class='btn' type='button' name='back'
		value="<s:text name="btn.back" />" onclick='do_back();' />&nbsp;
</s:form>

</div>

<%@ include file="/commons/footer.jsp"%>
