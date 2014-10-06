<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaWorkFlowMoveTypeList.title"/></title>
<content tag="heading"><fmt:message key="oaWorkFlowMoveTypeList.heading"/></content>
<meta name="menu" content="OaWorkFlowMoveTypeMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOaWorkFlowMoveType.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="oaWorkFlowMoveTypeList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="oaWorkFlowMoveTypeList" pagesize="25" class="tableDisplay oaWorkFlowMoveTypeList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editOaWorkFlowMoveType.html" paramId="id" paramProperty="id"
        titleKey="oaWorkFlowMoveTypeForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowMoveTypeForm.name"/>		<!--name--> 
    <display:column property="value" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowMoveTypeForm.value"/>		<!--value--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowMoveTypeForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowMoveTypeForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowMoveTypeForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowMoveTypeForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="oaWorkFlowMoveType"/>
    <display:setProperty name="paging.banner.items_name" value="oaWorkFlowMoveTypes"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("oaWorkFlowMoveTypeList");
</script>
