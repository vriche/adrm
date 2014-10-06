<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="sysMenuList.title"/></title>
<content tag="heading"><fmt:message key="sysMenuList.heading"/></content>
<meta name="menu" content="SysMenuMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editSysMenu.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="sysMenuList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="sysMenuList" pagesize="25" class="tableDisplay sysMenuList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editSysMenu.html" paramId="id" paramProperty="id"
        titleKey="sysMenuForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="sysMenuForm.name"/>		<!--name--> 
    <display:column property="parentId" sortable="true" headerClass="sortable"
         titleKey="sysMenuForm.parentId"/>		<!--parentId--> 
    <display:column property="treeLevel" sortable="true" headerClass="sortable"
         titleKey="sysMenuForm.treeLevel"/>		<!--treeLevel--> 
    <display:column property="displayNo" sortable="true" headerClass="sortable"
         titleKey="sysMenuForm.displayNo"/>		<!--displayNo--> 
    <display:column property="action" sortable="true" headerClass="sortable"
         titleKey="sysMenuForm.action"/>		<!--action--> 
    <display:column property="altImage" sortable="true" headerClass="sortable"
         titleKey="sysMenuForm.altImage"/>		<!--altImage--> 
    <display:column property="description" sortable="true" headerClass="sortable"
         titleKey="sysMenuForm.description"/>		<!--description--> 
    <display:column property="forward" sortable="true" headerClass="sortable"
         titleKey="sysMenuForm.forward"/>		<!--forward--> 
    <display:column property="height" sortable="true" headerClass="sortable"
         titleKey="sysMenuForm.height"/>		<!--height--> 
    <display:column property="image" sortable="true" headerClass="sortable"
         titleKey="sysMenuForm.image"/>		<!--image--> 
    <display:column property="location" sortable="true" headerClass="sortable"
         titleKey="sysMenuForm.location"/>		<!--location--> 
    <display:column property="onclick" sortable="true" headerClass="sortable"
         titleKey="sysMenuForm.onclick"/>		<!--onclick--> 
    <display:column property="onmouseout" sortable="true" headerClass="sortable"
         titleKey="sysMenuForm.onmouseout"/>		<!--onmouseout--> 
    <display:column property="onmouseover" sortable="true" headerClass="sortable"
         titleKey="sysMenuForm.onmouseover"/>		<!--onmouseover--> 
    <display:column property="pageNum" sortable="true" headerClass="sortable"
         titleKey="sysMenuForm.pageNum"/>		<!--pageNum--> 
    <display:column property="roles" sortable="true" headerClass="sortable"
         titleKey="sysMenuForm.roles"/>		<!--roles--> 
    <display:column property="target" sortable="true" headerClass="sortable"
         titleKey="sysMenuForm.target"/>		<!--target--> 
    <display:column property="title" sortable="true" headerClass="sortable"
         titleKey="sysMenuForm.title"/>		<!--title--> 
    <display:column property="tooltip" sortable="true" headerClass="sortable"
         titleKey="sysMenuForm.tooltip"/>		<!--tooltip--> 
    <display:column property="width" sortable="true" headerClass="sortable"
         titleKey="sysMenuForm.width"/>		<!--width--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="sysMenuForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="sysMenuForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="sysMenuForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="sysMenuForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="sysMenu"/>
    <display:setProperty name="paging.banner.items_name" value="sysMenus"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("sysMenuList");
</script>
