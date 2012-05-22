<%@ include file="/commons/header.jsp"%>

<script type="text/javascript"
	src="<s:url value='/scripts/category/add.js'/>">
</script>

<script type="text/javascript"
	src="<s:url value='/scripts/My97DatePicker/WdatePicker.js'/>">
</script>


<div class="path-bar"><s:text name="nav.procategory.management" />&nbsp;
<s:text	name="product.category.add"/></div>

<div class="content">

<s:fielderror />

<s:form name="add_form"	action="categoryAction_add" namespace="/category">
	<table border="0" width="820px">
		<tr>
			<td class="td-right" width="150"><s:text name="product.type" /></td>
			<td class="td-left">
			   <s:select name="proCategory.productType.id" list="productTypeList" listKey="id" listValue="name"/>
			   <font style="color: red">*</font>
			</td>
		</tr>
		<tr>
		    <td class="td-right"><s:text name="product.category.band" /></td>
			<td class="td-left"><s:textfield name="proCategory.brand" />
				<font style="color: red;">*</font><span id="brandSpan"></span></td>
			
			<td class="td-right" width="150"><s:text name="product.category.type" /></td>
			<td class="td-left"><s:textfield name="proCategory.type" />
				<font style="color: red;">*</font><span id="typeSpan"></span></td>
		</tr>
		<tr>
		    <td class="td-right"><s:text name="product.category.prize" /></td>
			<td class="td-left"><s:textfield name="proCategory.prize" /><span id="prizeSpan"></span></td>
			<td class="td-right"><s:text name="product.category.quantity" /></td>
			<td class="td-left"><s:textfield name="proCategory.quan" /></td>
		</tr>
		<tr>
			<td class="td-right"><s:text name="product.category.desription" /></td>
			<td class="td-left"><s:textarea name="proCategory.desc" cols="50" rows="3"/></td>
		</tr>
		<tr>
			<td class="td-right"><s:text name="product.category.specification" /></td>
			<td class="td-left"><s:textarea name="proCategory.spe" cols="50" rows="3"/></td>
		</tr>
		<tr>
			<td class="td-right"><s:text name="product.category.remark" /></td>
			<td class="td-left"><s:textarea name="proCategory.remark" cols="50" rows="3"/></td>
		</tr>
	</table>
	<input type="button" class="btn" value="<s:text name="btn.submit" />"
		onclick="formCheck()" />&nbsp;
	<s:reset cssClass="btn" value="%{getText('btn.reset')}" />&nbsp;
  	<input class='btn' type='button' name='back'
		value="<s:text name="btn.back" />" onclick='window.history.back();' />&nbsp;
</s:form>

</div>

<%@ include file="/commons/footer.jsp"%>
