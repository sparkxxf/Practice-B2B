<%@ include file="/commons/header.jsp"%>

<div
	style="color: red; padding-top: 20px; width: 700px; font-size: 16px">

<s:text name="error.labal" /> <br>
<br>
<div style="font-size: 12px;text-align: left; padding-left:20px">
<s:property	value="exception.message" />
</div>

</div>

<%@ include file="/commons/footer.jsp"%>