<%@ include file="/commons/header.jsp"%>


<div class="path-bar"></div>

<div class="content">

<s:fielderror />

<s:form name="add_form"	action="noticeAction_read" namespace="/notice">
	<s:hidden name="notice.id" value="%{notice.id}"></s:hidden>
	
	
	<table border="0" width="600px">
		<tr>
			<td class="td-right"><s:text name="notice.title" /></td>
			<td class="td-left"><s:property value="notice.title"/></td>
			</tr>
			<tr>
			<td class="td-right"><s:text name="notice.content" /></td>
			<td class="td-left">
				<s:property value="notice.content" />
			</td>
		</tr>
		
	</table>
	<input type="submit" class="btn" value="<s:text name="btn.notice.read" />"
		/>&nbsp;
  	<input class='btn' type='button' name='back'
		value="<s:text name="btn.back" />" onclick='window.history.back();' />&nbsp;
</s:form>

</div>

<%@ include file="/commons/footer.jsp"%>
