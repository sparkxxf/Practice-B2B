<%@ include file="/commons/header.jsp"%>


<script type="text/javascript" 
	src="<s:url value='/scripts/agent/add.js' />">
</script>



<script type="text/javascript">
   var AddActionURL = "<s:url action='agentAction_add' namespace='/agent' includeParams='none' />";
//var deleteConfirmationMessage = "<s:text name='user.message.deleteConfirmation' />";
// var userListSize = <s:property value="usersCount" />;

</script>

<div class="path-bar">
	<s:text name="nav.data.management" />
	-&nbsp;
	<s:text name="nav.protype.management" />
</div>

<div class="content">

	<s:fielderror />

	<s:form name="add_form" action="agentAction_add" namespace="/agent">

		<table border="0" width="600px">
			<tr>
				<td class="td-right"><s:text name="agent.size" /></td>
				<td class="td-left"><select name="agentType.size">
				<option value="0"><s:text name="size.small" /></option>
				<option value="1"><s:text name="size.middle" /></option>
				<option value="2"><s:text name="size.large" /></option>
				</select></td>
			</tr>
			
			<tr>
				<td class="td-right">
					<s:text name="agent.tel" />
				</td>
				<td class="td-left">
					<s:textfield name="agentType.tel" /><font style="color: red;">*</font><span id="telSpan"></span>
				</td>
			</tr>
			<tr>
				<td class="td-right">
					<s:text name="agent.zip" />
				</td>
				<td class="td-left">
					<s:textfield name="agentType.zip" />
				</td>
			</tr>
			<tr>
				<td class="td-right">
					<s:text name="agent.address" />
				</td>
				<td class="td-left" colspan"3">
					<s:textarea name="agentType.address" cols="50" rows="10" /><font style="color: red;">*</font><span id="addressSpan"></span>
				</td>
			</tr>
			<tr>
				<td class="td-right">
					<s:text name="agent.name" />
				</td>
				<td class="td-left">
					<s:textfield name="agentType.name" /><font style="color: red;">*</font><span id="nameSpan"></span>
				</td>
			</tr>
			<tr>
				<td class="td-right">
					<s:text name="agent.legal" /> <!--Legal representative-->
				</td>
				<td class="td-left">
					<s:textfield name="agentType.legal" /><font style="color: red;">*</font><span id="legalSpan"></span>
				</td>
			</tr>
			<tr>
				<td class="td-right">
					<s:text name="agent.fax" />
				</td>
				<td class="td-left">
					<s:textfield name="agentType.fax" />
				</td>
			</tr>
		</table>

		<input class='btn' type='button' value="<s:text name="btn.submit" />"
			onclick="formCheck()" />&nbsp;	
			<s:reset cssClass="btn" value="%{getText('btn.reset')}" /> &nbsp;
  		<input class='btn' type='button' name='back'
			value="<s:text name="btn.back" />" onclick='do_back();' />&nbsp;
	</s:form>

</div>

<%@ include file="/commons/footer.jsp"%>