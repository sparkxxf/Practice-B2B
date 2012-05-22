<%@ include file="/commons/header.jsp"%>

<script type="text/javascript"
	src="<s:url value='/scripts/agent_product/query.js'/>">
</script>



<script type="text/javascript">


var prepareQueryActionURL = "<s:url action='agent_productAction_prepareQuery' namespace='/agent_product' includeParams='none' />";
var do_publish_ActionURL = "<s:url action='agent_productAction_add' namespace='/agent_product' includeParams='none' />";
 var do_queryPublished_ActionURL = "<s:url action='agent_productAction_querypublish' namespace='/agent_product' includeParams='none' />";
//var deleteConfirmationMessage = "<s:text name='user.message.deleteConfirmation' />";
// var userListSize = <s:property value="usersCount" />;

</script>

<div class="path-bar">
	<s:text name="nav.publish.manage" />
	-&nbsp;
	<s:text name="nav.Published.manage" />
</div>

<s:form name="query_form" action="agent_productAction_query"
	namespace="/agent_product">
	<s:hidden id="selectedIds" name="selectedIds"></s:hidden>
	<div class="content">

		<s:fielderror />


		<table border="0" width="600px">
			<tr>
				<td class="td-right">
					<s:text name="product.type" />
				</td>
				<td class="td-left">
					<s:select name="proCategory.productType.id" list="allproductType"
						listKey="id" listValue="name" onchange="changeptype();" />
				</td>
				<td>
					<s:submit cssClass="btn" value="%{getText('btn.search.ppublish')}"
						method="querypublish" />
					&nbsp;
				</td>

			</tr>

		</table>


	</div>

	<s:if test="afterQuery">
		<div class="result">

			<div class="hint">
				<s:text name="product.category.result" />
			</div>

			<table width="600px" cellSpacing=0 border=1>
				<tr class="result-tr-th">
					<th>
						<input type="checkbox" onclick="selectAll(this,'ProductCategory.id');">
					</th>
					<th width="50">
						<s:text name="product.type" />
					</th>
					<th>
						<s:text name="product.category.band" />
					</th>
					<th>
						<s:text name="product.category.type" />
					</th>
					<th>
						<s:text name="product.category.quantity" />
					</th>
					<th>
						<s:text name="product.category.prize" />
					</th>
					<th>
						<s:text name="product.category.desription" />
					</th>
					<th>
						<s:text name="product.category.specification" />
					</th>
					<th>
						<s:text name="product.category.remark" />
					</th>
					


				</tr>
				<s:iterator value="resultList" status="index">
					<tr class="result-tr-td">
						<td>
							<input type="checkbox" name="ProductCategory.id"
								value="<s:property value="id" />" />
						</td>
						<td>
							<s:property value="productType.name" />
						</td>
						<td>
							<s:property value="brand" />
						</td>
						<td>
							<s:property value="type" />
						</td>
						<td>
							<s:property value="quan" />
						</td>
						<td>
							<s:property value="prize" />
						</td>
						<td>
							<s:property value="desc" />
						</td>
						<td>
							<s:property value="spe" />
						</td>
						<td>
							<s:property value="remark" />
						</td>
					</tr>
				</s:iterator>
			</table>

			<table border="0" width="600px">
				<tr>
					<td class="td-right">
						<s:text name="product.type" />
					</td>
					<td class="td-left">
						<s:select name="agent.id" list="allagent" listKey="id"
							listValue="name" />
					</td>

					<td>
						<!--<s:submit cssClass="btn" value="%{getText('btn.publish')}"
							method="add" />
							--><input class='btn' type='button' name='publishBtn'
		        value="<s:text name="btn.publish" />" onclick='do_publish();' />
						&nbsp;
					</td>

				</tr>

			</table>
		</div>
	</s:if>
</s:form>

<%@ include file="/commons/footer.jsp"%>


