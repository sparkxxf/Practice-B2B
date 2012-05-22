<%@ include file="/commons/header.jsp"%>

<script type="text/javascript"
	src="<s:url value='/scripts/systemrole/query.js' />">

</script>

<script type="text/javascript">

  var preAddActionURL = "<s:url action='systemroleAction_preAdd' namespace='/role' includeParams='none' />";
  var preUpdateActionURL = "<s:url action='systemroleAction_preUpdate' namespace='/role' includeParams='none' />";
  var deleteActionURL = "<s:url action='systemroleAction_delete' namespace='/role' includeParams='none' />";
//var deleteConfirmationMessage = "<s:text name='user.message.deleteConfirmation' />";
// var userListSize = <s:property value="usersCount" />;

</script>

<div class="path-bar">
	<s:text name="nav.user" />
	-&nbsp;
	<s:text name="nav.rolemessage.management" />
</div>

<div class="content">

	<s:fielderror />

	<s:form name="query_form" action="systemroleAction_query"
		namespace="/role">

		<table border="0" width="600px">
			<tr>
				<td class="td-right"><s:text name="role.name" /></td>
				<td class="td-left"><s:textfield name="systemrole.rolename" /></td>
				<td class="td-right"><s:text name="role.description" /></td>
				<td class="td-left"><s:textfield name="systemrole.roledesc" /></td>
			</tr>
		</table>
		<s:submit cssClass="btn" value="%{getText('btn.search')}"
			method="query" />&nbsp;
  	<input class='btn' type='button' name='add'
			value="<s:text name="btn.add" />" onclick='do_add();' />&nbsp;		
  	<input class='btn' type='button' name='update'
			value="<s:text name="btn.update" />" onclick='do_update();' />&nbsp;
  	<input class='btn' type='button' name='delete'
			value="<s:text name="btn.delete" />" onclick='do_delete();' />&nbsp;


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
</s:form>

<%@ include file="/commons/footer.jsp"%>


