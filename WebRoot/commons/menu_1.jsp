<%@ taglib prefix="s" uri="/struts-tags"%>

<s:if test="%{#session.sessionUser == null}">
	<jsp:forward page="/login.jsp" />
</s:if>
 
<ul id="nav">
<!-- security navigator -->
<s:iterator value="#session.custommenus">

    <!-- 1st. level menu -->
	<li class="top"><s:if test="%{enabled}">	
		<a href="#top2" class="top-link"><span class="down"><s:property value="name"/></span></a>
	</s:if> <!--<s:else>
		<a href="#" class="top-link-disabled"><span class="down-disabled"><s:property value="name"/></span></a>
	</s:else>-->
	
	    <!-- 2nd. level menu -->
		<ul class="sub">
		<s:iterator value="menuItemSet">
			<s:if test="%{enabled}">
				<li><a href="<s:url value="%{url}" />"><s:property value="name"/></a>
			</s:if> <!--<s:else>
				<li><div class="item-disabled"><s:property value="name"/></div></li>
			</s:else>-->
			
		</s:iterator>
		</ul>
	</li>
</s:iterator>

  <!-- common navigator  -->
  <li class="tail">
    <a href="<s:url value="/login/loginAction_logout" />"><span><s:text name="nav.logout" /></span></a>
  </li>
  <li class="tail">
    <a href="<s:url value="/notice/noticeAction_queryNotRead.action" />"><span><s:text name="nav.home" /></span></a>
  </li>

</ul>

