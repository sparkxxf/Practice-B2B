<%@ include file="/commons/header.jsp"%>
<script type="text/javascript"
	src="<s:url value='/scripts/My97DatePicker/WdatePicker.js'/>">
</script>



<div class="path-bar">
	<s:text name="order.management" />-<s:text name="order.statics" />
</div>

<div class="content">

	<s:fielderror />

<s:form name="query_form" action="orderAction_statisticalReport"
		namespace="/order">
	<table border="0" width="600px">
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
		<tr>
			<td class="td-right"><s:text name="agent.management.name" /></td>
			<td class="td-left">
			    	<s:select name="agent.id" list="agentList" listKey="id" listValue="name" emptyOption="true"/>
			</td>
			<td class="td-right"><s:text name="product.type.typename" /></td>
			<td class="td-left">
			    <s:select name="productType.id" list="productList" listKey="id" listValue="name" emptyOption="true"/>
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
			<th width="120"><s:text name="agent.management.name" /></th>
			<th width="120"><s:text name="product.type.typename" /></th>
			<th width="80"><s:text name="order.month" /></th>
			<th width="150"><s:text name="order.all.count" /></th>
			<th width="80"><s:text name="order.all.price" /></th>
		</tr>
		<s:iterator value="reportList" status="index">
			<tr class="result-tr-td">
				<td><s:property value="agentName" /></td>
				<td><s:property value="typeName" /></td>
				<td><s:property value="months" /></td>
				<td><s:property value="sumProduct" /></td>
				<td><s:property value="sumPrice" /></td>
			</tr>
		</s:iterator>
	</table>
</div>
</s:if>

<%@ include file="/commons/footer.jsp"%>


