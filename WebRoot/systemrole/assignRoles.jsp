<%@ include file="/commons/header.jsp"%>

<script type="text/javascript"
	src="<s:url value='/scripts/systemrole/assignRoles.js'/>">
</script>
<script type="text/javascript">
	var saveRoleFuncsActionURL = "<s:url action='roleassignfuncsAction_saveRoleFuncs' namespace='/roleassign' includeParams='none' />";
    
	
</script>

<div class="path-bar"><s:text name="role.base.path" />&nbsp;
<s:text	name="role.assignFunc.path" /></div>

<div class="content">

<s:fielderror />

<s:text name="role.name" /><br>


<s:form name="assign_form"	action="roleassignfuncsAction_reFindBySystemRoleId" namespace="/roleassign">
<s:hidden id="assignedFuncsId" name="assignedFuncsId" />

<div class="info-display">
	
	<select name="role.id" onchange="changeSystemRole();">
		<option value="<s:property value="role.id"/>" ><s:property value="role.rolename"/></option>
	   <s:iterator value="roleList">
	      <s:if test="id!=role.id"><option value="<s:property value="id"/>" ><s:property value="rolename"/></option></s:if>
	   </s:iterator>
	</select>
</div>

<div class="select">
<table border="0" width="600">

<tr>
<td width="40%"><s:text name="role.availableFuncs" /></td>
<td width="20%"></td>
<td width="40%"><s:text name="role.assignedFuncs" /></td>
</tr>

<tr>

<td width="40%">
<s:select name="avfuncs" list="hasnotAssignFuncsList" listKey="id" listValue="name" 
	multiple="true" size="15"
	ondblclick="move_option(document.assign_form.avfuncs, document.assign_form.asfuncs)" />
</td>

<td width="20%">
<input class='btn' type='button' name='addOne'
	value="<s:text name="btn.addOne" />" 
	onclick="move_option(document.assign_form.avfuncs, document.assign_form.asfuncs);" />
<input class='btn' type='button' name='addAll'
	value="<s:text name="btn.addAll" />" 
	onclick="move_all(document.assign_form.avfuncs, document.assign_form.asfuncs);" />
<input class='btn' type='button' name='removeOne'
	value="<s:text name="btn.removeOne" />" 
	onclick="move_option(document.assign_form.asfuncs, document.assign_form.avfuncs);" />
<input class='btn' type='button' name='removeAll'
	value="<s:text name="btn.removeAll" />" 
	onclick="move_all(document.assign_form.asfuncs, document.assign_form.avfuncs);" />
</td>

<td width="40%">
<s:select id="asfuncs" name="asfuncs" list="assignedFuncs" listKey="id" listValue="name" 
	multiple="true" size="15" 
	ondblclick="move_option(document.assign_form.asfuncs, document.assign_form.avfuncs)" />
</td>

</tr>
</table>
</div>

<input class='btn' type='button' name='save'
	value="<s:text name="btn.save" />" onclick='do_saveRoleFuncs();' />&nbsp;
<input class='btn' type='submit' name='btn.reset' 
	value="<s:text name="btn.reset" />"/>

</s:form>

</div>

<%@ include file="/commons/footer.jsp"%>

