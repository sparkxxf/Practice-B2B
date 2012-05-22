<%@ include file="/commons/header.jsp"%>

<script type="text/javascript"
	src="<s:url value='/scripts/category/query.js'/>">
</script>
<script type="text/javascript" src="<s:url value='/scripts/common.js'/>"></script>


<script type="text/javascript">

	var preAddActionURL = "<s:url action='categoryAction_preAdd' namespace='/category' includeParams='none' />";
	 var preUpdateActionURL = "<s:url action='categoryAction_preUpdate' namespace='/category' includeParams='none' />";
	 var deleteActionURL = "<s:url action='categoryAction_delete' namespace='/category' includeParams='none' />";
	//var deleteConfirmationMessage = "<s:text name='user.message.deleteConfirmation' />";
   // var userListSize = <s:property value="usersCount" />;
	
</script>

<div class="path-bar">
<s:text name="nav.data.management" />-&nbsp;<s:text name="nav.procategory.management" /></div>

<s:form name="query_form" action="categoryAction_query" namespace="/category">
<div class="content">

<s:fielderror />


	
	<table border="0" width="600px">

		<tr>
			<td class="td-right"><s:text name="product.type" /></td>
			<td class="td-left">
				<s:select name="proCategory.productType.id" list="productTypeList" listKey="id" listValue="name" emptyOption="true"/>
			</td>	
		</tr>
		
		<tr>
		    <td class="td-right"><s:text name="product.category.brand" /></td>
			<td class="td-left"><s:textfield name="proCategory.brand" /></td>
			<td class="td-right"><s:text name="product.category.type" /></td>
			<td class="td-left"><s:textfield name="proCategory.type" /></td>
		</tr>
	</table>
	<s:submit cssClass="btn" value="%{getText('btn.search')}" method="query" />&nbsp;
  	<input class='btn' type='button' name='add'
		value="<s:text name="btn.add" />" onclick='do_add();' />&nbsp;		
  	<input class='btn' type='button' name='update'
		value="<s:text name="btn.update" />" onclick='do_update();' />&nbsp;
  	<input class='btn' type='button' name='delete'
		value="<s:text name="btn.delete" />" onclick='do_delete();' />&nbsp;

</div>

<s:if test="afterQuery">
<div class="result">

	<div class="hint"><s:text name="product.category.result" /></div>

	<table width="" cellSpacing=0 border=1>
		<tr class="result-tr-th">
		    <th></th>
			<th width="100"><s:text name="product.type" /></th>
			<th width="100"><s:text name="product.category.brand" /></th>
			<th width="100"><s:text name="product.category.type" /></th>
			<th width="100"><s:text name="product.category.quantity" /></th>
			<th width="100"><s:text name="product.category.prize" /></th>
			<th width="150"><s:text name="product.category.desription" /></th>
			<th width="150"><s:text name="product.category.specification" /></th>
			<th width="150"><s:text name="product.category.remark" /></th>
		</tr>
		<s:iterator value="resultList" status="index">
			<tr class="result-tr-td">
			  <td><input type="radio"  name="proCategory.id" value="<s:property value="id" />" /></td>
			  <td><s:property value="productType.name" /></td>
			  <td><s:property value="brand" /></td>
			  <td><s:property value="type" /></td>
			  <td><s:property value="quan" /></td>
			  <td><s:property value="prize" /></td>
			  <td><s:property value="desc" /></td>
			  <td><s:property value="spe" /></td>
			  <td><s:property value="remark" /></td>
			  
			</tr>
		</s:iterator>
	</table>
</div>
</s:if>
</s:form>

<%@ include file="/commons/footer.jsp"%>


