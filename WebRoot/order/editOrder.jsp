<%@ include file="/commons/header.jsp"%>


<script type="text/javascript">
	
	var do_queryURL = "<s:url action='orderAction_queryforUpdate' namespace='/order' includeParams='none' />";
	
	function do_queryOrder() {	
		document.query_form.action = do_queryURL;
		document.query_form.submit();
	}
	
	
</script>
<script language="javascript" type="text/javascript"
	src="<s:url value='/scripts/datepicker/WdatePicker.js' />">
</script>

<div class="path-bar">
<s:text name="nav.order" />-&nbsp;<s:text name="nav.order.edit" />
</div>


<div class="content">

<s:form name="query_form" id="query_form"	action="orderAction_edit" namespace="/order">
	
	<s:hidden value="%{order.id}" name="order.id"></s:hidden>
  			
	<table border="0" width="600px">
		<tr>
			<td class="td-right"><s:text name="order.number" /></td>
			<td class="td-left"><s:textfield  name="order.orderCode"  /></td>
		</tr>
		<tr>
			<td class="td-right"><s:text name="order.status" /></td>
			<td class="td-left">
					<select name="order.status">
						<option selected="selected" value="-1">
							<s:text name="order.status.select" />
						</option>
						<option value="0">
							<s:text name="order.created" />
						</option>
						<option value="3">
							<s:text name="status.rufused" />
						</option>
					</select>
			</td>
		</tr>
		<tr>
			<td class="td-right"><s:text name="order.createTime.start" /></td>
			<td class="td-left">
					<input name="order.createTime" class="Wdate"
						value="<s:date format="yyyy-MM-dd" name="order.createTime"/>"
						type="text" id="d4321" onFocus="WdatePicker({skin:'whyGreen',maxDate:'#F{$dp.$D(\'d421\',{d:-3});}'})" />
						
			</td>
		</tr>
		<tr>
			<td class="td-right"><s:text name="order.createTime.dead" /></td>
			<td class="td-left">
				<input  name="order.createTime" class="Wdate" 
					value="<s:date format="yyyy-MM-dd" name="order.createTime"/>"
					type="text" id="d421" 
					onfocus="WdatePicker({skin:'whyGreen',maxDate:'%y-%M-%d'})"/>
			</td>
		</tr>
	</table>
	
	<input class='btn' type='button' name='query'
		value="<s:text name="btn.order.query" />" onclick='do_queryOrder();' />&nbsp;
	<s:reset cssClass="btn" value="%{getText('btn.reset')}" />&nbsp;
	
</s:form>

</div>

<s:if test="afterQuery">
<div class="result">
	<div class="hint">
		<s:text name="user.query.result" />
	</div>
	<table width="800px" cellSpacing=0 border=1>
		<tr class="result-tr-th">
			
			<th width="120"><s:text name="order.code" /></th>
			<th width="120"><s:text name="order.status" /></th>
			<th width="80"><s:text name="order.all.count" /></th>
			<th width="150"><s:text name="order.all.price" /></th>
			<th width="80"><s:text name="order.create.user" /></th>
			<th width="150"><s:text name="order.create.date" /></th>
			<th width="150"><s:text name="user.management.ownagent" /></th>
			
		</tr>
		<s:iterator value="resultList" status="index">
			<tr class="result-tr-td">
				<td>
				    <s:if test="status==2">
				        <a href="orderAction_toDetailOrder.action?order.id=<s:property value="id"/>"><s:property value="orderCode" /></a>
				    </s:if>
				    <s:else>
				        <a href="orderAction_viewOrder.action?order.id=<s:property value="id"/>"><s:property value="orderCode" /></a>
				    </s:else>
				</td>
				<td>
					<s:if test="status==0"><s:text name="order.created" /></s:if>
					<s:elseif test="status==1"><s:text name="order.submit" /></s:elseif>
					<s:elseif test="status==2"><s:text name="order.approvaled" /></s:elseif>
					<s:elseif test="status==3"><s:text name="order.unapprovaled" /></s:elseif>
				</td>
				<td><s:property value="allItemCount" /></td>
				<td><s:property value="allItemPrice" /></td>
				<td><s:property value="create_user.realName" /></td>
				<td><s:property value="createTime" /></td>
				<td><s:property value="create_user.agent.name" /></td>
			</tr>
		</s:iterator>
	</table>
</div>
</s:if>

<%@ include file="/commons/footer.jsp"%>
