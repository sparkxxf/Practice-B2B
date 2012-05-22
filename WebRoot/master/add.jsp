<%@ include file="/commons/header.jsp"%>



<div class="path-bar"></div>

<div class="content">

<s:fielderror />

<s:form name="add_form"	action="masterAction_add" namespace="/master">

	<table border="0" width="600px">
		<tr>
			<td class="td-right"><s:text name="user.agent" /></td>
			<td class="td-left">
			    <s:select name="user.management_agent.id" list="allAgentList" listKey="id" listValue="name" emptyOption="true"/>
			</td>

		    <td class="td-right"><s:text name="user.type.1" /></td>
			<td class="td-left">
                <s:select name="user.id" list="allManagerList" listKey="id" listValue="realName" emptyOption="true"/>
			</td>
		</tr>
		<tr>
			<td class="td-right"><s:text name="order.approval.enable" /></td>
			<td class="td-left"><s:radio name="user.enabled_approval" list="#{1:'Yes',0:'No'}" listKey="key" listValue="value" value="0"/></td>
		</tr>
		<tr>
			<td colspan="2"><font color="red">${message }</font></td>
		</tr>
	</table>
	
	<s:submit cssClass="btn" value="%{getText('btn.submit')}"></s:submit>
  	<input class='btn' type='button' name='back'
		value="<s:text name="btn.back" />" onclick='window.history.back();' />&nbsp;
</s:form>

</div>

<%@ include file="/commons/footer.jsp"%>