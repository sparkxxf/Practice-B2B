<%@ include file="/commons/header.jsp"%>


<script type="text/javascript" 
src="<s:url value='/scripts/proType/update.js' />">
</script>



<script type="text/javascript">
//var preAddActionURL = "<s:url action='produtTypeAction_preUpdate' namespace='/data' includeParams='none' />";
//var deleteConfirmationMessage = "<s:text name='user.message.deleteConfirmation' />";
// var userListSize = <s:property value="usersCount" />;

</script>

<div class="path-bar">
	<s:text name="nav.data.management" />
	-&nbsp;
	<s:text name="nav.protype.management" />

</div>

<div class="content">

	<s:fielderror />

	<s:form name="update_form" action="produtTypeAction_update" namespace="/data">

		<table border="0" width="600px">
		
			<tr>
				<td class="td-right">
					<s:text name="product.type.id" />
				</td>
				<td class="td-left">
					<s:textfield name="productType.code" readonly="true"/>
				</td>
			</tr>
		
			<tr>
				<td class="td-right">
					<s:text name="product.type.name" />
				</td>
				<td class="td-left">
					<s:textfield name="productType.name" />
					<font style="color: red;">*</font>   <!-- <div>id="error"</div> -->
					<input type="hidden" name="productType.id" value="<s:property value="productType.id" />"/>
				</td>
			</tr>

			<tr>
				<td class="td-right">
					<s:text name="product.type.desc" />
				</td>
				<td class="td-left"colspan"3">
					<s:textarea name="productType.desc" cols="50" rows="10" />
				</td>
			</tr>
		</table>

		<input class='btn' type='button' value="<s:text name="btn.submit" />"
			onclick="formCheck()" />&nbsp;	
			<s:reset cssClass="btn" value="%{getText('btn.reset')}" /> &nbsp;
  	<input class='btn' type='button' name='back'
			value="<s:text name="btn.back" />" onclick='do_back();' />&nbsp;
</s:form>

</div>

<s:if test="afterQuery">
	<div class="result">

		<div class="hint">
			<s:text name="user.query.result" />
		</div>

		<table width="600px" cellSpacing=0 border=1>
			<tr class="result-tr-th">

				<th width="150">
					<s:text name="product.type.id" />
				</th>
				<th>
					<s:text name="product.type.name" />
				</th>
				<th>
					<s:text name="product.type.desc" />
				</th>
			</tr>
			<s:iterator value="ruesultList">
				<tr class="result-tr-td">
					<td>
						<s:property value="code" />
					</td>
					<td>
						<s:property value="name" />
					</td>
					<td>
						<s:property value="desc" />
					</td>
				</tr>
			</s:iterator>
		</table>
	</div>
</s:if>

<%@ include file="/commons/footer.jsp"%>


