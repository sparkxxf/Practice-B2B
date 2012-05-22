<%@ include file="/commons/header.jsp"%>

<script type="text/javascript">
	var preQueryActionURL = "<s:url action='noticeAction_prepareQuery' namespace='/notice' includeParams='none' />";
	var addActionURL = "<s:url action='noticeAction_add' namespace='/notice' includeParams='none' />";
	var message = "<s:text name='please.input.something' />";
	
	function do_query() {
		 document.add_form.action=preQueryActionURL;
		 document.add_form.submit();
	}
	function formCheck() {
		var title = document.getElementById('title').value;
		if (title.length <=0) {
			alert(message);
			return false;
		}
		document.add_form.action=addActionURL;
	 	document.add_form.submit();
	}
</script>




<div class="path-bar"><s:text name="publish.management" />-<s:text name="publish.add" /></div>

<div class="content">

<s:fielderror />

<s:form name="add_form"	action="noticeAction_add" namespace="/notice">
	
	<input type="button" class="btn" value="<s:text name="notice.query.published" />"
		onclick="do_query();" />&nbsp;
	
	<table border="0" width="600px">
		<tr>
			<td class="td-right"><s:text name="notice.title" /></td>
			<td class="td-left"><s:textfield name="notice.title" id="title" /></td>
			<td class="td-right"><s:text name="notice.status" /></td>
			<td class="td-left">
				<select name="notice.status">
				    <option value="1"><s:text name="notice.status.yes"/></option>
				    <option value="0"><s:text name="notice.status.no"/></option>
				</select>
			</td>
		</tr>
		<tr>
		    <td class="td-right"><s:text name="notice.mandatory" /></td>
			<td class="td-left">
				<select name="notice.mandatory">
				    <option value="1"><s:text name="notice.mandatory.yes"/></option>
				    <option value="0"><s:text name="notice.mandatory.no"/></option>
				</select>
			</td>
		    <td class="td-right"><s:text name="notice.scope" /></td>
			<td class="td-left">
				<select name="notice.scope">
					<option value="-2"><s:text name="notice.all.user"></s:text></option>
					<option value="-1"><s:text name="notice.all.agent"></s:text></option>
					<s:iterator value="agentList">
				        <option value="<s:property value="id"/>" ><s:property value="name"/></option>
				    </s:iterator>
				</select>
			</td>
		</tr>
		<tr>
		    <td class="td-right"><s:text name="notice.content" /></td>
			<td class="td-left" colspan="3">
				<s:textarea name="notice.content" cols="50" rows="3"/>
			</td>
		</tr>
		
	</table>
	<input type="button" class="btn" value="<s:text name="btn.submit" />"
		onclick="formCheck('add')" />&nbsp;
	<s:reset cssClass="btn" value="%{getText('btn.reset')}" />&nbsp;
  	<input class='btn' type='button' name='back'
		value="<s:text name="btn.back" />" onclick='window.history.back();' />&nbsp;
</s:form>

</div>

<%@ include file="/commons/footer.jsp"%>
