<%@ include file="/commons/header.jsp"%>

<script type="text/javascript"
	src="<s:url value='/scripts/user/query.js' />">

</script>

<script type="text/javascript">

var preAddActionURL = "<s:url action='userAction_preAdd' namespace='/user' includeParams='none' />";
var preUpdateActionURL = "<s:url action='userAction_preUpdate' namespace='/user' includeParams='none' />";
var deleteActionURL = "<s:url action='userAction_delete' namespace='/user' includeParams='none' />";
//var deleteConfirmationMessage = "<s:text name='user.message.deleteConfirmation' />";
// var userListSize = <s:property value="usersCount" />;

</script>

<div class="path-bar">
	<s:text name="nav.user.management" />
	-&nbsp;
	<s:text name="nav.agentmessage.management" />
</div>

<div class="content">

	<s:fielderror />

	<s:form name="query_form" action="userAction_query"
		namespace="/user">

		
		<table border="0" width="600px">
		
			<tr>
				<td class="td-right">
					<s:text name="user.type" />
				</td>
				<td class="td-left">
				<select name="user.type"  onchange="changeAgentSelect(this)";>
					<option selected="selected" value="-1" ><s:text name="popdown.tip" /></option>
					<option value="0"><s:text name="user.agent" /></option>
					<option value="1"><s:text name="user.manager" />
					</option>
				</select>
					
					
				</td>
		 
		  
				<td class="td-right">
			        <s:text name="user.own_agent" />
			    </td>
			    
		  		<td class="td-left">
		  		<s:select name="user.agent.id" disabled="true" list="agentList"
						listKey="id" listValue="name" emptyOption="true"/>
				</td>
		    	
		    </tr>
		
		
			<tr>
				<td class="td-right">
					<s:text name="user.name" />
				</td>
				<td class="td-left">
					<s:textfield name="user.userName" />
				</td>
				<td class="td-right">
					<s:text name="user.realname" />
				</td>
				<td class="td-left">
					<s:textfield name="user.realName" />
				</td>
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

		<div class="hint">
			<s:text name="user.query.result" />
		</div>

		<table width="800px" cellSpacing=0 border=1>
			<tr class="result-tr-th">
				<th></th>
				<th width="100"><s:text name="user.name" /></th>
				<th width="100"><s:text name="user.realname" /></th>
			    <th width="90"><s:text name="user.email" /></th>
				<th width="80"><s:text name="user.tel" /></th>
				<th width="80"><s:text name="user.deadline" /></th>
				<th width="80"><s:text name="own_agent" /></th>
				<th width="90"><s:text name="user.remark" /></th>
			
			</tr>
			
			
			<s:iterator value="resultList">
				<tr class="result-tr-td">
					<td>
						<input type="radio" name="types" value="<s:property value="id" />" />
					</td>
					<td>
						<s:property value="userName" />
					</td>
					<td>
						<s:property value="realName" />
					</td>
					<td>
						<s:property value="email" />
					</td>
					<td>
						<s:property value="tel" />
					</td>
					<td>
						<s:date format="yyyy-MM-dd" name="dead_line" />
					</td>
					<td>
						<s:property value="agent.name" />
					</td>
					<td>
						<s:property value="remark" />
					</td>
					
				</tr>
			</s:iterator>
		</table>
	</div>
</s:if>
</s:form>
<%@ include file="/commons/footer.jsp"%>