<%@ include file="/commons/header.jsp"%>

<script type="text/javascript"
	src="<s:url value='/scripts/master/query.js' />">

</script>

<script type="text/javascript">

var preAddActionURL = "<s:url action='masterAction_preAdd' namespace='/master' includeParams='none' />";
var deleteActionURL = "<s:url action='masterAction_delete' namespace='/master' includeParams='none' />";
</script>

<div class="path-bar">
	<s:text name="nav.master.management" />
	-&nbsp;
	<s:text name="nav.agentmessage.management" />
</div>


<s:form name="query_form" action="masterAction_query"
	namespace="/master">
<div class="content">

	<s:fielderror />

		
		<table border="0" width="600px">
		
			<tr>
				<td class="td-right">
			         <s:text name="user.agent" />
			    </td>
			    
		  		<td class="td-left">
		        <s:select name="user.management_agent.id"  list="allAgentList" listKey="id" listValue="name" emptyOption="true" />
				</td>
		  		<td class="td-right">
			        <s:text name="user.type.1" />
			    </td>
			    
		  		<td class="td-left">
		        <s:select name="user.id"  list="allManagerList" listKey="id" listValue="realName" emptyOption="true"/>
				</td>
			</tr>	
		</table>
		
		<s:submit cssClass="btn" value="%{getText('btn.search')}"
			method="query" />&nbsp;
  		<input class='btn' type='button' name='add'
			value="<s:text name="btn.add" />" onclick='do_add();' />&nbsp;		
  		<input class='btn' type='button' name='delete'
			value="<s:text name="btn.delete" />" onclick='do_delete();' />&nbsp;

	
</div>
<s:if test="afterQuery">
	<div class="result">

		<div class="hint">
			<s:text name="user.query.result" />
		</div>

		<table width="800px" cellSpacing=0 border=1>
			<tr class="result-tr-th">
				<th></th>
				<th width="100"><s:text name="user.realname" /></th>
				<th width="100"><s:text name="user.name" /></th>
			    <th width="90"><s:text name="order.approval.enable" /></th>
				<th width="80"><s:text name="agent.code" /></th>
				<th width="80"><s:text name="agent.name" /></th>			
			</tr>
			
			
			<s:iterator value="resultList">
				<tr class="result-tr-td">
					<td>
						<input type="radio" name="userId" value="<s:property value="id" />" />
					</td>
					
					<td>
						<s:property value="realName" />
					</td>
					<td>
						<s:property value="userName" />
					</td>
					<td>
						<s:property value="enabled_approval" />
					</td>
					<td>
						<s:property value="management_agent.code" />
					</td>
					<td>
						<s:property value="management_agent.name" />
					</td>
				</tr>
			</s:iterator>
		</table>
	</div>
</s:if>
</s:form>
<%@ include file="/commons/footer.jsp"%>


