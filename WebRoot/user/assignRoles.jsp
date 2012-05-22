<%@ include file="/commons/header.jsp"%>

<script type="text/javascript"
	src="<s:url value='/scripts/user/assignRoles.js'/>">
</script>
<script type="text/javascript">
	var saveUserRolesActionURL = "<s:url action='userAssignRoleAction_saveUserRoles' namespace='/userrole' includeParams='none' />";
	var backActionURL = "<s:url action='userAction_back' namespace='/userrole' includeParams='none' />";
	
</script>

<div class="path-bar"><s:text name="user.base.path" />&nbsp;
<s:text	name="user.assignRole.path" /></div>

<div class="content">

<s:fielderror />

<s:text name="user.assign.userinfo" /><br>


<s:form name="assign_form"	action="userAssignRoleAction_reFindByUserId" namespace="/userrole">
<s:hidden id="assignedRoleIds" name="assignedRoleIds" />

<div class="info-display">
	
	<select name="user.id" onchange="changeUser();">
		<option value="<s:property value="user.id"/>" ><s:property value="user.userName"/></option>
	   <s:iterator value="userList">
	      <s:if test="id!=user.id"><option value="<s:property value="id"/>" ><s:property value="userName"/></option></s:if>
	   </s:iterator>
	 </select>
</div>

<div class="select">
<table border="0" width="600">

<tr>
<td width="40%"><s:text name="user.availableRoles" /></td>
<td width="20%"></td>
<td width="40%"><s:text name="user.assignedRoles" /></td>
</tr>

<tr>

<td width="40%">
<s:select name="avroles" list="hasNotAssignRoleList" listKey="id" listValue="rolename" multiple="true" size="15"
	ondblclick="move_option(document.assign_form.avroles, document.assign_form.asroles)" />
</td>

<td width="20%">
<input class='btn' type='button' name='addOne'
	value="<s:text name="btn.addOne" />" 
	onclick="move_option(document.assign_form.avroles, document.assign_form.asroles);" />
<input class='btn' type='button' name='addAll'
	value="<s:text name="btn.addAll" />" 
	onclick="move_all(document.assign_form.avroles, document.assign_form.asroles);" />
<input class='btn' type='button' name='removeOne'
	value="<s:text name="btn.removeOne" />" 
	onclick="move_option(document.assign_form.asroles, document.assign_form.avroles);" />
<input class='btn' type='button' name='removeAll'
	value="<s:text name="btn.removeAll" />" 
	onclick="move_all(document.assign_form.asroles, document.assign_form.avroles);" />
</td>

<td width="40%">
<s:select id="asroles" name="asroles" list="assignedRoleSet" listKey="id" listValue="rolename" multiple="true" size="15" 
	ondblclick="move_option(document.assign_form.asroles, document.assign_form.avroles)" />
</td>

</tr>
</table>
</div>

<input class='btn' type='button' name='save'
	value="<s:text name="btn.save" />" onclick='do_saveUserRoles();' />&nbsp;
<input class='btn' type='submit' name='btn.reset' 
	value="<s:text name="btn.reset" />"/>

</s:form>

</div>

<%@ include file="/commons/footer.jsp"%>

