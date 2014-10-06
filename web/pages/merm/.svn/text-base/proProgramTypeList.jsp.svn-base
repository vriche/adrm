<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="proProgramTypeList.title"/></title>
<content tag="heading"><fmt:message key="proProgramTypeList.heading"/></content>
<meta name="menu" content="ProProgramTypeMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editProProgramType.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="proProgramTypeList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="proProgramTypeList" pagesize="25" class="tableDisplay proProgramTypeList"
    export="true" requestURI="">

    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="proProgramTypeForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="proProgramTypeForm.createDate"/>		<!--createDate--> 
    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editProProgramType.html" paramId="id" paramProperty="id"
        titleKey="proProgramTypeForm.id"/>
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="proProgramTypeForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="proProgramTypeForm.modifyDate"/>		<!--modifyDate--> 
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="proProgramTypeForm.name"/>		<!--name--> 
    <display:column property="displayNo" sortable="true" headerClass="sortable"
         titleKey="proProgramTypeForm.displayNo"/>		<!--displayNo--> 
    <display:column property="parentId" sortable="true" headerClass="sortable"
         titleKey="proProgramTypeForm.parentId"/>		<!--parentId--> 
    <display:column property="treeLevel" sortable="true" headerClass="sortable"
         titleKey="proProgramTypeForm.treeLevel"/>		<!--treeLevel--> 
    <display:setProperty name="paging.banner.item_name" value="proProgramType"/>
    <display:setProperty name="paging.banner.items_name" value="proProgramTypes"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("proProgramTypeList");
</script>
