<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaWorkFlowCheckStateList.title"/></title>
<content tag="heading"><fmt:message key="oaWorkFlowCheckStateList.heading"/></content>
<meta name="menu" content="OaWorkFlowCheckStateMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOaWorkFlowCheckState.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="oaWorkFlowCheckStateList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="oaWorkFlowCheckStateList" pagesize="25" class="tableDisplay oaWorkFlowCheckStateList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editOaWorkFlowCheckState.html" paramId="id" paramProperty="id"
        titleKey="oaWorkFlowCheckStateForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowCheckStateForm.name"/>		<!--name--> 
    <display:column property="value" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowCheckStateForm.value"/>		<!--value--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowCheckStateForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowCheckStateForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowCheckStateForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowCheckStateForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="oaWorkFlowCheckState"/>
    <display:setProperty name="paging.banner.items_name" value="oaWorkFlowCheckStates"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("oaWorkFlowCheckStateList");
</script>
