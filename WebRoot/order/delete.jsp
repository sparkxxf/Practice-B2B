<%@ include file="/commons/header.jsp"%>
<script type="text/javascript"
	src="<s:url value='/scripts/order/delete.js'/>">
</script>
<script type="text/javascript"
	src="<s:url value='/scripts/My97DatePicker/WdatePicker.js'/>">
</script>

<script type="text/javascript">
var message = "<s:text name='publis.select.one' />";

var do_delURL = "<s:url action='orderAction_delete' namespace='/order' includeParams='none' />";
	function do_delete() {
	if (!checkRadio("order.id")) {
		alert('Please select one');
		return;
	}
	var flag = confirm("are you sure delete?");
	if(flag) {
		document.delete_form.action = do_delURL;
		document.delete_form.submit();
		
	}

}
	
</script>

<div class="path-bar">
	<s:text name="order.management" />
	-&nbsp;
	<s:text name="order.delete" />
</div>

<s:form name="delete_form" action="orderAction_delete" namespace="/order">
	<div class="content">
		<s:hidden id="selectedIds" name="selectedIds"></s:hidden>
		<table border="0" width="600px">
			<tr>
				<td class="td-right">
					<s:text name="order.code" />
				</td>
				<td class="td-left">
					<s:textfield name="order.orderCode" />
				</td>
				<td class="td-right">
					<s:text name="order.status" />
				</td>
				<td class="td-left">
					<select name="order.status">
						<option selected="selected" value="-1">
							<s:text name="order.status.select" />
						</option>
						<option value="0">
							<s:text name="status.created" />
						</option>
						<option value="3">
							<s:text name="status.rufused" />
						</option>
					</select>
				</td>
			</tr>

			<tr>
				<td class="td-right">
					<s:text name="order.createTime.start" />
				</td>
				<td class="td-left">
					<input id="d4311" class="Wdate" type="text" name="start_date"
						onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}'})" />
				</td>
				<td class="td-right">
					<s:text name="order.createTime.dead" />
				</td>
				<td class="td-left">
					<input id="d4312" class="Wdate" type="text" name="end_date"
						onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}'})" />
				</td>
			</tr>
			
		</table>
		<input type="button" class="btn" value="<s:text name="btn.search"/>"
			onclick="formCheck()" />
		&nbsp;
		<s:reset cssClass="btn" value="%{getText('btn.reset')}" />
		&nbsp;
		<input class='btn' type='button' name='delete'
			value="<s:text name="btn.delete" />" onclick='do_delete();' />
		&nbsp;
	</div>

	<s:if test="afterQuery">
		<div class="result">

			<div class="hint">
				<s:text name="user.query.result" />
			</div>

			<table width="850px" cellSpacing=0 border=1>
				<tr class="result-tr-th">
				<th></th>
					<th>
						<s:text name="order.code" />
					</th>
					<th>
						<s:text name="order.status" />
					</th>
					<th>
						<s:text name="order.all.count" />
					</th>
					<th>
						<s:text name="order.all.price" />
					</th>
					<th>
						<s:text name="order.create.user" />
					</th>
					<th>
						<s:text name="order.createtime" />
					</th>
					<th>
						<s:text name="agent.name" />
					</th>


				</tr>
				<s:iterator value="results" status="index">
					<tr class="result-tr-td">
						
						<td>
				      		 <input type="radio"  name="order.id" value="<s:property value="id" />" />
					    </td>

						<td>
							<a href="orderAction_roderDetail.action?order.id=<s:property value="id"/>"><s:property
									value="orderCode" /> </a>
						</td>
						<td>
							<s:if test="status==0">
								<s:text name="status.created" />
							</s:if>
							<s:elseif test="status==3">
								<s:text name="status.rufused" />
							</s:elseif>
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
							<s:date format="yyyy-MM-dd" name="createTime"/>
						</td>
						<td>
							<s:property value="create_user.agent.name" />
						</td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</s:if>
</s:form>

<%@ include file="/commons/footer.jsp"%>