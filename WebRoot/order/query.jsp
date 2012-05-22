<%@ include file="/commons/header.jsp"%>


<script type="text/javascript"
	src="<s:url value='/scripts/My97DatePicker/WdatePicker.js'/>">
</script>

<script type="text/javascript">

//var preAddActionURL = "<s:url action='agentAction_preAdd' namespace='/agent' includeParams='none' />";

</script>

<div class="path-bar">
	<s:text name="order.management" />
	-&nbsp;
	<s:text name="order.query" />
</div>

<div class="content">

	<s:fielderror />

	<s:form name="query_form" action="orderAction_query" namespace="/order">


		<table border="0" width="600px">

			<tr>
				<td class="td-left">
					<s:text name="order.code" />
				</td>
				<td class="td-right">
					<input type="text" name="order.orderCode" />
				</td>
				<td class="td-left">
					<s:text name="order.status" />
				</td>
				<td class="td-right">
					<select name="order.status">
						<option selected="selected" value="-1">
							<s:text name="order.status.select" />
						</option>
						<option value="0">
							<s:text name="status.created" />
						</option>
						<option value="1">
							<s:text name="status.commited" />
						</option>
						<option value="2">
							<s:text name="status.approvaled" />
						</option>
						<option value="3">
							<s:text name="status.rufused" />
						</option>
					</select>
				</td>
			</tr>
			

			<tr>
				<td class="td-left">
					<s:text name="order.createTime.start" />
				</td>
				<td class="td-right">
					<input id="d4311" class="Wdate" type="text" name="start_date"
						onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}'})" />
				</td>

				<td class="td-left">
					<s:text name="order.createTime.dead" />
				</td>
				<td class="td-right">
					<input id="d4312" class="Wdate" type="text" name="end_date"
						onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}'})" />
				</td>
			</tr>

		</table>
		<s:submit cssClass="btn" value="%{getText('btn.search')}"
			method="query" />&nbsp;
		<s:reset cssClass="btn" value="%{getText('btn.reset')}" /> &nbsp;

	</s:form>
</div>

<s:if test="afterQuery">
	<div class="result">
		
		<table width="800px" cellSpacing=0 border=1>
			<tr class="result-tr-th">

				<th width="100">
					<s:text name="order.code" />
				</th>
				<th width="100">
					<s:text name="order.status" />
				</th>
				<th width="90">
					<s:text name="order.all.count" />
				</th>
				<th width="90">
					<s:text name="order.all.price" />
				</th>
				<th width="80">
					<s:text name="order.create.user" />
				</th>
				<th width="80">
					<s:text name="order.createtime" />
				</th>
				<th width="80">
					<s:text name="agent.name" />
				</th>
			</tr>
			
			<s:iterator value="resultList">
				<tr class="result-tr-td">

					<td>
						<a
							href="orderAction_roderDetail.action?order.id=<s:property value="id"/>"><s:property
								value="orderCode" /> </a>
					</td>
					<td>
						<s:if test="status==0">
							<s:text name="status.created" />
						</s:if>
						<s:elseif test="status==1">
							<s:text name="status.commited" />
						</s:elseif>
						<s:elseif test="status==2">
							<s:text name="status.approvaled" />
						</s:elseif>
						<s:else>
							<s:text name="status.rufused" />
						</s:else>
					</td>
					<td>
						<s:property value="allItemCount" />
					</td>
					<td>
						<s:property value="allItemPrice" />
					</td>
					<td>
						<s:property value="create_user.realName" />
					</td>
					<td>
						<s:date format="yyyy-MM-dd" name="createTime" />
						
					</td>
					<td>
						<s:property value="create_user.agent.name" />
					</td>
				</tr>
			</s:iterator>
		</table>
	</div>
</s:if>


<%@ include file="/commons/footer.jsp"%>


