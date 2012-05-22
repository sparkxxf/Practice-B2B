<%@ include file="/commons/header.jsp" %>


<div class="path-bar"></div>

<div class="content">

<div class="result">

	<div class="hint"><s:text name="notice.hasnotread" /></div>

	<table width="600px" cellSpacing=0 border=1>
		<tr class="result-tr-th">
			<th width="60"><s:text name="notice.code" /></th>
			<th><s:text name="notice.title" /></th>
			<th><s:text name="notice.mandatory" /></th>
			<th><s:text name="notice.publish.date" /></th>
			<th><s:text name="notice.status" /></th>
			<th><s:text name="notice.publish.user" /></th>
		</tr>
		<s:iterator value="resultList" status="index">
			<tr <s:if test="mandatory==1">class="result-tr-td-green"</s:if><s:else>class="result-tr-td"</s:else>>
			  <td><a href="/b2b/notice/noticeAction_detail.action?notice.id=<s:property value="id" />"><s:property value="code" /></a></td>
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



</div>



<%@ include file="/commons/footer.jsp" %>