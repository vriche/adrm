<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="branchList.title"/></title>
<content tag="heading"><fmt:message key="branchList.heading"/></content>
<meta name="menu" content="BranchMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editBranch.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="branchList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="branchList" pagesize="25" class="tableDisplay branchList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editBranch.html" paramId="id" paramProperty="id"
        titleKey="branchForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="branchForm.name"/>		<!--name--> 
    <display:column property="orgId" sortable="true" headerClass="sortable"
         titleKey="branchForm.orgId"/>		<!--orgId--> 
    <display:column property="parentId" sortable="true" headerClass="sortable"
         titleKey="branchForm.parentId"/>		<!--parentId--> 
    <display:column property="treeLevel" sortable="true" headerClass="sortable"
         titleKey="branchForm.treeLevel"/>		<!--treeLevel--> 
    <display:column property="displayNo" sortable="true" headerClass="sortable"
         titleKey="branchForm.displayNo"/>		<!--displayNo--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="branchForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="branchForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="branchForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="branchForm.modifyDate"/>		<!--modifyDate--> 
   <display:column property="org.name" sortable="true" headerClass="sortable"
         titleKey="branchForm.modifyDate"/>		<!--modifyDate-->      
    <display:setProperty name="paging.banner.item_name" value="branch"/>
    <display:setProperty name="paging.banner.items_name" value="branchs"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("branchList");
</script>
