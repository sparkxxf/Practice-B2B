<%@ include file="/commons/header.jsp"%>

<script type="text/javascript"
	src="<s:url value='/scripts/proType/query.js' />">

</script>

<script type="text/javascript">

var preAddActionURL = "<s:url action='produtTypeAction_preAdd' namespace='/data' includeParams='none' />";
var preUpdateActionURL = "<s:url action='produtTypeAction_preUpdate' namespace='/data' includeParams='none' />";
var deleteActionURL = "<s:url action='produtTypeAction_delete' namespace='/data' includeParams='none' />";
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

	<s:form name="query_form" action="produtTypeAction_query"
		namespace="/data">

		<table border="0" width="600px">
			<tr>
				<td class="td-right">
					<s:text name="product.type.id" />
				</td>
				<td class="td-left">
					<s:textfield name="productType.code" />
				</td>
				<td class="td-right">
					<s:text name="product.type.name" />
				</td>
				<td class="td-left">
					<s:textfield name="productType.name" />
				</td>
			</tr>
		</table>
		<s:submit cssClass="btn" value="%{getText('btn.search')}"
			method="query" />&nbsp;
  	<input class='btn' type='button' name='add'
			value="<s:text name="btn.add" />" onclick='do_add();' />&nbsp;		
  	<input class='btn' type='button' name='update'
			value="<s:text name="btn.update" />" onclick='do_update();' />&nbsp;
  	<input class='btn' type='button' name='delete'
			value="<s:text name="btn.delete" />" onclick='do_delete();' />&nbsp;

	
</div>

<s:if test="afterQuery">
	<div class="result">

		<div class="hint">
			<s:text name="user.query.result" />
		</div>

		<table width="600px" cellSpacing=0 border=1>
			<tr class="result-tr-th">
				<th></th>
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
						<input type="radio" name="types" value="<s:property value="id" />" />
					</td>
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
</s:form>

<%@ include file="/commons/footer.jsp"%>


