<%@ include file="/commons/header.jsp"%>

<script type="text/javascript"
	src="<s:url value='/scripts/agent/query.js' />">

</script>

<script type="text/javascript">

var preAddActionURL = "<s:url action='agentAction_preAdd' namespace='/agent' includeParams='none' />";
//var preUpdateActionURL = "<s:url action='produtTypeAction_preUpdate' namespace='/data' includeParams='none' />";
var deleteActionURL = "<s:url action='agentAction_delete' namespace='/agent' includeParams='none' />";
//var deleteConfirmationMessage = "<s:text name='user.message.deleteConfirmation' />";
// var userListSize = <s:property value="usersCount" />;

</script>

<div class="path-bar">
	<s:text name="nav.data.management" />
	-&nbsp;
	<s:text name="nav.agentmessage.management" />
</div>

<div class="content">

	<s:fielderror />

	<s:form name="query_form" action="agentAction_query" namespace="/agent">


		<table border="0" width="600px">

			<tr>
				<td class="td-right">
					<s:text name="agent.size" />
				</td>
				<td class="td-left">
					<select name="agentType.size">
						<option selected="selected" value="-1">
							<s:text name="please.select" />
						</option>
						<option value="0">
							<s:text name="size.small" />
						</option>
						<option value="1">
							<s:text name="size.middle" />
						</option>
						<option value="2">
							<s:text name="size.large" />
						</option>
					</select>
				</td>


				<td class="td-right">
					<s:text name="agent.name" />
				</td>

				<td class="td-left">
					<select name="agentType.name">
						<option selected="selected" value="">
							<s:text name="please.select" />
						</option>
						<s:iterator value="agentList">
							<option>
								<s:property value="name" />
							</option>
						</s:iterator>
					</select>
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
				<th width="100">
					<s:text name="agent.code" />
				</th>
				<th width="100">
					<s:text name="agent.name" />
				</th>
				<th width="90">
					<s:text name="agent.size" />
				</th>
				<th width="80">
					<s:text name="agent.legal" />
				</th>
				<th width="80">
					<s:text name="agent.tel" />
				</th>
				<th width="80">
					<s:text name="agent.fax" />
				</th>
				<th width="90">
					<s:text name="agent.zip" />
				</th>
				<th width="150">
					<s:text name="agent.address" />
				</th>
			</tr>


			<s:iterator value="resultList">
				<tr class="result-tr-td">
					<td>
						<input type="radio" name="types" value="<s:property value="id" />" />
					</td>
					<td>
						<s:property value="code" />
					</td>
					<td>
						<s:property value="name" />
					</td>



					<td>
						<s:if test="size==0">
							<s:text name="size.small" />
						</s:if>
						<s:elseif test="size==1">
							<s:text name="size.middle" />
						</s:elseif>
						<s:else>
							<s:text name="size.large" />
						</s:else>

					</td>




					<td>
						<s:property value="legal" />
					</td>
					<td>
						<s:property value="tel" />
					</td>
					<td>
						<s:property value="fax" />
					</td>
					<td>
						<s:property value="zip" />
					</td>
					<td>
						<s:property value="address" />
					</td>
				</tr>
			</s:iterator>
		</table>
	</div>
</s:if>
</s:form>

<%@ include file="/commons/footer.jsp"%>


