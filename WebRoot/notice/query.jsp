<%@ include file="/commons/header.jsp"%>

<script type="text/javascript"
	src="<s:url value='/scripts/My97DatePicker/WdatePicker.js'/>">
</script>

<script type="text/javascript"
	src="<s:url value='/scripts/common.js'/>">
</script>

<script type="text/javascript">
	var deleteActionURL = "<s:url action='noticeAction_delete' namespace='/notice' includeParams='none' />";
	
	var message = "<s:text name='please.select.one' />";
	
	function do_delete() {
		var chkBoxes = document.getElementsByName('notice.id');
		var ids='';
		for(var i = 0; i < chkBoxes.length; i++) {
			if (chkBoxes[i].checked) {
				ids += chkBoxes[i].value + ","
			}
		}
		if (ids.length > 0) {
			ids = ids.substr(0,ids.length - 1);
			document.getElementById('selectedIds').value = ids;
			
			document.query_form.action = deleteActionURL;
			document.query_form.submit();
		} else {
			alert(message);
		}
	}
	
	function selectAll(chkBox,otherBoxesName) {
	var otherBoxes = document.getElementsByName(otherBoxesName);

	if (chkBox.checked) {
		for (i=0; i<otherBoxes.length; i++) {
			otherBoxes[i].checked = true;
		}
	
	}else{
		for (i=0; i<otherBoxes.length; i++) {
			otherBoxes[i].checked = false;
		}
	}
	}
	
	function do_back(){
	      document.noticeAction_query.submit();
	}
</script>

<div class="path-bar"><s:text name="publish.management" />-<s:text name="publish.query" /></div>


<div class="content">

<s:form name="query_form" action="noticeAction_query" namespace="/notice">
<s:hidden id="selectedIds" name="selectedIds"></s:hidden>

<s:fielderror />

	
	<table border="0" width="600px">
		<tr>
			<td class="td-right"><s:text name="notice.title" /></td>
			<td class="td-left"><s:textfield name="notice.title" /></td>
			<td class="td-right"><s:text name="notice.code" /></td>
			<td class="td-left"><s:textfield name="notice.code" /></td>
		</tr>
		<tr>
		    <td class="td-right"><s:text name="notice.mandatory" /></td>
			<td class="td-left">
				<select name="notice.mandatory">
				    <option value="-1"><s:text name="order.appr.sel"/></option>
				    <option value="1"><s:text name="notice.mandatory.yes"/></option>
				    <option value="0"><s:text name="notice.mandatory.no"/></option>
				</select>
			</td>
			<td class="td-right"><s:text name="notice.status" /></td>
			<td class="td-left">
				<select name="notice.status">
				    <option value="-1"><s:text name="order.appr.sel"/></option>
				    <option value="1"><s:text name="notice.status.yes"/></option>
				    <option value="0"><s:text name="notice.status.no"/></option>
				</select>
			</td>
		</tr>
		<tr>
			<td class="td-right"><s:text name="publish.start.date" /></td>
			<td class="td-left">
				<input id="d4311" name="start_date" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')||\'2020-10-01\'}'})"/> 
			</td>
			<td class="td-right"><s:text name="publish.end.date" /></td>
			<td class="td-left">
				<input id="d4312" name="end_date" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}'})"/>
			</td>
		</tr>
	</table>
	<input type="submit" class="btn" value="<s:text name="btn.search" />" />&nbsp;
	<input class='btn' type='button' name='delete'
		value="<s:text name="btn.delete" />" onclick='do_delete();' />&nbsp;
	<s:reset cssClass="btn" value="%{getText('btn.reset')}" />&nbsp;
  	<input class='btn' type='button' name='back'
		value="<s:text name="btn.back" />" onclick='do_back();' />&nbsp;
</s:form>
</div>
<s:if test="afterQuery">
<div class="result">

	<div class="hint"><s:text name="user.query.result" /></div>

	<table width="600px" cellSpacing=0 border=1>
		<tr class="result-tr-th">
		    <th><input type="checkbox" onclick="selectAll(this,'notice.id');"></th>
			<th width="60"><s:text name="notice.code" /></th>
			<th><s:text name="notice.title" /></th>
			<th><s:text name="notice.mandatory" /></th>
			<th><s:text name="notice.publish.date" /></th>
			<th><s:text name="notice.status" /></th>
			<th><s:text name="notice.publish.user" /></th>
		</tr>
		<s:iterator value="resultList" status="index">
			<tr class="result-tr-td">
			  <td><input type="checkbox"  name="notice.id" value="<s:property value="id" />" /></td>
			  <td><s:property value="code" /></td>
			  <td><s:property value="title" /></td>
			  <td>
			      <s:if test="mandatory==1"><s:text name="notice.mandatory.yes"/></s:if>
			      <s:else><s:text name="notice.mandatory.no"/></s:else>
			  </td>
			  <td><s:date format="yyyy-MM-dd" name="create_date"/></td>
			  <td>
			 	  <s:if test="status==1"><s:text name="notice.status.yes"/></s:if>
			      <s:else><s:text name="notice.status.no"/></s:else>
			  </td>
			  <td><s:property value="publisher.realName" /></td> 
			</tr>
		</s:iterator>
	</table>
</div>

</s:if>


<%@ include file="/commons/footer.jsp"%>


