<%@ include file="/commons/header.jsp"%>

<script type="text/javascript">
	var queryProductByTypeURL = "<s:url action='orderAction_queryProductByType' namespace='/order' includeParams='none' />";
	var listCartURL = "<s:url action='orderAction_listCart' namespace='/order' includeParams='none' />";
	var listCartURL = "<s:url action='orderAction_listCart' namespace='/order' includeParams='none' />";

	
	function changeTypes() {	
		document.query_form.action = queryProductByTypeURL;
		document.query_form.submit();
	}
	
	function list_cart() {
		document.query_form.action = listCartURL;
		document.query_form.submit();
	}
	function openNewWin(id) {
	    //window.open('orderAction_preBuyProduct.action?product.id='+id,'','height=400,width=800');
	    window.open('orderAction_preBuyProduct.action?product.id=' + id+'&'+'order.id='+"<s:property value='order.id'/>" ,'',
			'height=400,width=800');
	    
	}

	//var deleteConfirmationMessage = "<s:text name='user.message.deleteConfirmation' />";
   // var userListSize = <s:property value="usersCount" />;
	
</script>

<div class="path-bar">
<s:text name="order.management" />-&nbsp;<s:text name="order.select.product" /></div>

<s:form name="query_form" action="orderAction_queryProductByType" namespace="/order">
<div class="content">

<s:fielderror />

	<s:hidden name="order.id" value="%{order.id}"></s:hidden><!-- while update order -->
	<!--<s:property value="order.id"/>-->
	<s:hidden value="%{product.id}" name="product.id"></s:hidden>
	<!--<s:property value="product.id"/>-->
	
	<table border="0" width="600px">
		<tr>
			<td class="td-right"><s:text name="product.type.name" /></td>
			<td class="td-left">
			    <select name="productType.id" onchange="changeTypes();">
					<option value="<s:property value="productType.id"/>" ><s:property value="productType.name"/></option>
				    <s:iterator value="typeList">
				        <s:if test="id!=productType.id"><option value="<s:property value="id"/>" ><s:property value="name"/></option></s:if>
				    </s:iterator>
		        </select>
			</td>
			<td class="td-right"><s:text name="order.create.user" />:</td>
			<td class="td-left"><s:property value="user.realName"/></td>
		</tr>
		<tr>
			<td class="td-left" colspan="2"><input class='btn' type='button' value="<s:text name="order.list.cart" />" onclick='list_cart();' /></td>
			<td class="td-right"><s:text name="user.own_agent" />:</td>
			<td class="td-left"><s:property value="user.agent.name"/></td>
		</tr>
	</table>

</div>

<s:if test="afterQuery">
<div class="result">

	<div class="hint"><s:text name="user.query.result" /></div>

	<table width="" cellSpacing=0 border=1>
		<tr class="result-tr-th">
			<th width="100"><s:text name="product.category.brand" /></th>
			<th width="100"><s:text name="product.category.type" /></th>
			<th width="200"><s:text name="product.category.desription" /></th>
			<th width="100"><s:text name="product.category.quantity" /></th>
			<th width="100"><s:text name="product.category.prize" /></th>
			<th width="200"><s:text name="product.category.remark" /></th>
		</tr>
		<s:iterator value="resultList" status="index">
			<tr class="result-tr-td">
			   <td><s:property value="brand" /></td>
			  <td><a href="javascript:void(0)"  onclick="openNewWin(<s:property value="id" />);"><s:property value="type" /></a></td>
			  <td><s:property value="desc" /></td>
			  <td><s:property value="quan" /></td>
			  <td><s:property value="prize" /></td>
			  <td><s:property value="remark" /></td>
			</tr>
		</s:iterator>
	</table>
</div>
</s:if>
</s:form>

<%@ include file="/commons/footer.jsp"%>


