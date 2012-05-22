<%@ include file="/commons/header.jsp"%>


<script type="text/javascript" 
     src="<s:url value='/scripts/systemrole/update.js' />">
</script>



<script type="text/javascript">

//var preAddActionURL = "<s:url action='userAction_preAdd' namespace='/user' includeParams='none' />";
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

	<s:form name="update_form" action="systemroleAction_update" namespace="/role">

		<table border="0" width="600px">
			<tr>
				<td class="td-right"><s:text name="role.name" /></td>
				<td class="td-left"><s:textfield name="systemrole.rolename" />
					<font style="color: red;">*</font>
					<input type="hidden" name="systemrole.id" value="<s:property value="systemrole.id" />"/>  
				</td>
			</tr>

			<tr>
				<td class="td-right"><s:text name="role.description" /></td>
				<td class="td-left"colspan"3"><s:textarea name="systemrole.roledesc" cols="50" rows="10" /></td>
			</tr>
		</table>

		<input class='btn' type='button' value="<s:text name="btn.submit" />"
			onclick="formCheck()" />&nbsp;	
			<s:reset cssClass="btn" value="%{getText('btn.reset')}" /> &nbsp;
  	<input class='btn' type='button' name='back'
			value="<s:text name="btn.back" />" onclick='do_back();' />&nbsp;
</s:form>

</div>

<s:if test="afterQuery">
	<div class="result">

		<div class="hint"><s:text name="role.assign.roleinfo" /></div>

		<table width="600px" cellSpacing=0 border=1>
			<tr class="result-tr-th">
				<th></th>
				<th><s:text name="role.name" /></th>
				<th><s:text name="role.description" /></th>
			</tr>
			<s:iterator value="ruesultList">
				<tr class="result-tr-td">
					
					<td><input type="radio" name="types" value="<s:property value="id" />" /></td>
					<td><s:property value="rolename" /></td>
					<td><s:property value="roledesc" /></td>
					
				</tr>
			</s:iterator>
		</table>
	</div>
</s:if>

<%@ include file="/commons/footer.jsp"%>


