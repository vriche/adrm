<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaWorkFlowTypeList.title"/></title>
<content tag="heading"><fmt:message key="oaWorkFlowTypeList.heading"/></content>
<meta name="menu" content="OaWorkFlowTypeMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOaWorkFlowType.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="oaWorkFlowTypeList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="oaWorkFlowTypeList" pagesize="25" class="tableDisplay oaWorkFlowTypeList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editOaWorkFlowType.html" paramId="id" paramProperty="id"
        titleKey="oaWorkFlowTypeForm.id"/>
    <display:column property="displayNo" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowTypeForm.displayNo"/>		<!--displayNo--> 
    <display:column property="nodeLevel" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowTypeForm.nodeLevel"/>		<!--nodeLevel--> 
    <display:column property="parentId" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowTypeForm.parentId"/>		<!--parentId--> 
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowTypeForm.name"/>		<!--name--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowTypeForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowTypeForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowTypeForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowTypeForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="oaWorkFlowType"/>
    <display:setProperty name="paging.banner.items_name" value="oaWorkFlowTypes"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("oaWorkFlowTypeList");
</script>
