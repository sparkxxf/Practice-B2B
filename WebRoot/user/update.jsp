<%@ include file="/commons/header.jsp"%>


<script type="text/javascript"
	src="<s:url value='/scripts/user/update.js' />">
</script>
<script language="javascript" type="text/javascript"
	src="<s:url value='/scripts/datepicker/WdatePicker.js' />">
</script>


<script type="text/javascript">

var UpdateActionURL = "<s:url action='userAction_update' namespace='/user' includeParams='none' />";
//var deleteConfirmationMessage = "<s:text name='user.message.deleteConfirmation' />";
// var userListSize = <s:property value="usersCount" />;

</script>

<div class="path-bar">
	<s:text name="nav.user.management" />
	-&nbsp;
	<s:text name="nav.user.message" />
</div>

<div class="content">

	<s:fielderror />

	<s:form name="update_form" action="userAction_update" namespace="/user">

		<table border="0" width="600px">
			<tr>
				<td class="td-right">
					<s:text  name="user.type" />
				</td>
				<td class="td-left">
					<select name="user.type" onchange="changeAgentSelect(this);">
						<option value="1">
							<s:text  name="user.manager" />
						</option>
						<option value="0">
							<s:text  name="user.agent" />
						</option>
					</select>
				
				<!--<s:property  value="user.type" />
				--></td>
			</tr>
			<tr>
				<td>
					<input type="hidden" name="user.id"
						value="<s:property value="user.id" />" />
				</td>
			</tr>
			<tr>
				<td class="td-right">
					<s:text name="user.username" />
				</td>
				<td class="td-left">
					<s:property  value="user.userName" />
				</td>
			</tr>
			<tr>
				<td class="td-right">
					<s:text name="user.realname" />
				</td>
				<td class="td-left">
					<s:textfield name="user.realName" /><font style="color: red;">*</font><span id="realNameSpan"></span>
				</td>
			</tr>
			<tr>
				<td class="td-right">
					<s:text name="user.email" />
				</td>
				<td class="td-left">
					<s:textfield name="user.email" /><font style="color: red;">*</font><span id="emailSpan"></span>
				</td>
			</tr>
			<tr>
				<td class="td-right">
					<s:text name="user.agent" />
				</td>
				<td class="td-left">
					<s:select name="user.agent.id" disabled="true" list="agentList"
						listKey="id" listValue="name" />
				</td>
			</tr>
			<tr>
				<td class="td-right">
					<s:text name="user.deadline" />
				</td>
				<td class="td-left">
					<input name="user.dead_line" class="Wdate"
						value="<s:date format="yyyy-MM-dd" name="user.dead_line"/>"
						type="text" id="d15"
						onFocus="WdatePicker({isShowClear:false,readOnly:true})" />
				</td>
			</tr>
			<tr>
				<tr>
					<td class="td-right">
						<s:text name="user.tel" />
					</td>
					<td class="td-left">
						<s:textfield name="user.tel" /><font style="color: red;">*</font><span id="telSpan"></span>
					</td>
				</tr>
				<tr>
					<td class="td-right">
						<s:text name="user.remark" />
					</td>
					<td class="td-left"colspan"3">
						<s:textarea name="user.remark" cols="50" rows="10" />
					</td>
				</tr>
		</table>

		<input class='btn' type='button' value="<s:text name="btn.submit" />"
			onclick="formCheck()" />&nbsp;	
			<s:reset cssClass="btn" value="%{getText('btn.reset')}" /> &nbsp;
  		<input class='btn' type='button' name='back'
			value="<s:text name="btn.back" />" onclick='do_back();' />&nbsp;




</div>
</s:form>


<%@ include file="/commons/footer.jsp"%>