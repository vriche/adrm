<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="sysResourceList.title"/></title>
<content tag="heading"><fmt:message key="sysResourceList.heading"/></content>
<meta name="menu" content="SysResourceMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editSysResource.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="sysResourceList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="sysResourceList" pagesize="25" class="tableDisplay sysResourceList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editSysResource.html" paramId="id" paramProperty="id"
        titleKey="sysResourceForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="sysResourceForm.name"/>		<!--name--> 
    <display:column property="resType" sortable="true" headerClass="sortable"
         titleKey="sysResourceForm.resType"/>		<!--resType--> 
    <display:column property="resString" sortable="true" headerClass="sortable"
         titleKey="sysResourceForm.resString"/>		<!--resString--> 
    <display:column property="memo" sortable="true" headerClass="sortable"
         titleKey="sysResourceForm.memo"/>		<!--memo--> 
    <display:setProperty name="paging.banner.item_name" value="sysResource"/>
    <display:setProperty name="paging.banner.items_name" value="sysResources"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("sysResourceList");
</script>
