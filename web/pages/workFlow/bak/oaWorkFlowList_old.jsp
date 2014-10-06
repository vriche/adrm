<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaWorkFlowList.title"/></title>
<content tag="heading"><fmt:message key="oaWorkFlowList.heading"/></content>
<meta name="menu" content="OaWorkFlowMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOaWorkFlow.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="oaWorkFlowList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="oaWorkFlowList" pagesize="25" class="tableDisplay oaWorkFlowList"
    export="true" requestURI="">

    <display:column property="name" sortable="true" headerClass="sortable"
    	 url="/editOaWorkFlow.html" paramId="id" paramProperty="id"
         titleKey="oaWorkFlowForm.name"/>		<!--name--> 
    <display:column property="checkResultId" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowForm.checkResultId"/>		<!--checkResultId--> 
    <display:column property="isFlowLeve" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowForm.isFlowLeve"/>		<!--isFlowLeve--> 
    <display:column property="workFlowTypeId" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowForm.workFlowTypeId"/>		<!--workFlowTypeId-->
    <display:setProperty name="paging.banner.item_name" value="oaWorkFlow"/>
    <display:setProperty name="paging.banner.items_name" value="oaWorkFlows"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("oaWorkFlowList");
</script>
