<%@ include file="/commons/header.jsp"%>

<script type="text/javascript"
	src="<s:url value='/scripts/My97DatePicker/WdatePicker.js'/>">
</script>

<script type="text/javascript">

//var preAddActionURL = "<s:url action='agentAction_preAdd' namespace='/agent' includeParams='none' />";
function do_back(){
 window.history.back();
}
</script>

<div class="path-bar">
	<s:text name="order.management" />
	-&nbsp;
	<s:text name="order.detail" />
</div>

<div class="content">

	<s:fielderror />

	<s:form name="orderdetail_form" action="order_submit"
		namespace="/order">

		<s:hidden value="%{order.id}" name="order.id"/>
		
		<input class='btn' type='button' name='back'
			value="<s:text name="btn.back" />" onclick='do_back();' />&nbsp;
		
		<table border="0" width="600px" >

			<tr>
				<td width="60" class="td-right">
					<s:text name="order.code"/>
				</td >
				<td width="60" class="td-left">
					<s:property value="order.orderCode"/>
				</td>
			</tr>
			<tr>
				<td width="80" class="td-right">
					<s:text name="people.name"/>
				</td>
				<td width="60" class="td-left">
					<s:property value="order.receivePeopleName"/>
				</td>
			</tr>
			<tr>
				<td width="80" class="td-right">
					<s:text name="people.address"/>
				</td>
				<td class="td-left">
					<s:property value="order.address" />
				</td>
			</tr>
			<tr>
				<td width="60" class="td-right">
					<s:text name="people.post.code"/>
				</td>
				<td class="td-left">
					<s:property value="order.postCode" />
				</td>
			</tr>
			<tr>
				<td width="60" class="td-right">
					<s:text name="people.call"/>
				</td>
				<td class="td-left">
					<s:property value="order.call" />
				</td>
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

				<th width="60">
					<s:text name="product.name" />
				</th>
				<th width="60">
					<s:text name="product.type" />
				</th>
				<th width="80">
					<s:text name="product.price" />
				</th>
				<th width="80">
					<s:text name="cart.count" />
				</th>
			</tr>
		</div>
			<s:iterator value="order.itemSet" status="index">
				<tr class="result-tr-td">
					<td>
						<s:property value="product.brand" />
					</td>
					<td>
						<s:property value="product.productType.name" />
					</td>
					<td>
						<s:property value="product.prize" />
					</td>
					<td>
						<s:property value="number" />
					</td>
				</tr>
			</s:iterator>
		</table>
	</div>



<%@ include file="/commons/footer.jsp"%>


