<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaWorkFlowCheckResultList.title"/></title>
<content tag="heading"><fmt:message key="oaWorkFlowCheckResultList.heading"/></content>
<meta name="menu" content="OaWorkFlowCheckResultMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOaWorkFlowCheckResult.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="oaWorkFlowCheckResultList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="oaWorkFlowCheckResultList" pagesize="25" class="tableDisplay oaWorkFlowCheckResultList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editOaWorkFlowCheckResult.html" paramId="id" paramProperty="id"
        titleKey="oaWorkFlowCheckResultForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowCheckResultForm.name"/>		<!--name--> 
    <display:column property="value" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowCheckResultForm.value"/>		<!--value--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowCheckResultForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowCheckResultForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowCheckResultForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowCheckResultForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="oaWorkFlowCheckResult"/>
    <display:setProperty name="paging.banner.items_name" value="oaWorkFlowCheckResults"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("oaWorkFlowCheckResultList");
</script>
