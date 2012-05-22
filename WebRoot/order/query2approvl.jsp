<%@ include file="/commons/header.jsp"%>
<script type="text/javascript"
	src="<s:url value='/scripts/My97DatePicker/WdatePicker.js'/>">
</script>



<div class="path-bar">
	<s:text name="order.management" />-<s:text name="order.appr" />
</div>

<div class="content">

	<s:fielderror />

<s:form name="query_form" action="orderAction_queryForApprovl"
		namespace="/order">
	<table border="0" width="600px">
		<tr>
			<td class="td-right"><s:text name="order.code" /></td>
			<td class="td-left"><s:textfield name="productType.code" /></td>
			<td class="td-right"><s:text name="order.status" /></td>
			<td class="td-left"><select name="order.status">
			    <option value="1"><s:text name="order.status.1"></s:text></option>
			</select></td>
		</tr>
		<tr>
			<td class="td-right"><s:text name="order.createTime.start" /></td>
			<td class="td-left">
				<input id="d4311" name="start_date" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')||\'2020-10-01\'}'})"/> 
			</td>
			<td class="td-right"><s:text name="order.createTime.dead" /></td>
			<td class="td-left">
				<input id="d4312" name="end_date" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}'})"/>
			</td>
		</tr>
	</table>
	<s:submit cssClass="btn" value="%{getText('btn.search')}"
		 />&nbsp;
  	<input type="reset" class="btn" value="<s:text name="btn.reset"/>"/>
  	
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
			<th width="80"><s:text name="oder.create.user" /></th>
			<th width="150"><s:text name="order.create.date" /></th>
			<th width="150"><s:text name="user.management.ownagent" /></th>
			
		</tr>
		<s:iterator value="resultList" status="index">
			<tr class="result-tr-td">
				<td>
				    <a href="orderAction_detailToApprol.action?order.id=<s:property value="id"/>"><s:property value="orderCode" /></a>
				</td>
				<td>
					<s:if test="status==0"><s:text name="order.status.0" /></s:if>
					<s:elseif test="status==1"><s:text name="order.status.1" /></s:elseif>
					<s:elseif test="status==2"><s:text name="order.status.2" /></s:elseif>
					<s:elseif test="status==3"><s:text name="order.status.3" /></s:elseif>
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


