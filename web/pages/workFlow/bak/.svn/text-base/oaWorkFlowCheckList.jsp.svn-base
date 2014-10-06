<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaWorkFlowCheckList.title"/></title>
<content tag="heading"><fmt:message key="oaWorkFlowCheckList.heading"/></content>
<meta name="menu" content="OaWorkFlowCheckMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOaWorkFlowCheck.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="oaWorkFlowCheckList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="oaWorkFlowCheckList" pagesize="25" class="tableDisplay oaWorkFlowCheckList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editOaWorkFlowCheck.html" paramId="id" paramProperty="id"
        titleKey="oaWorkFlowCheckForm.id"/>
    <display:column property="checkIdea" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowCheckForm.checkIdea"/>		<!--checkIdea--> 
    <display:column property="checkResultId" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowCheckForm.checkResultId"/>		<!--checkResultId--> 
    <display:column property="checkUserId" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowCheckForm.checkUserId"/>		<!--checkUserId--> 
    <display:column property="sysEventId" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowCheckForm.sysEventId"/>		<!--sysEventId--> 
    <display:column property="workFlowTypeId" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowCheckForm.workFlowTypeId"/>		<!--workFlowTypeId--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowCheckForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowCheckForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowCheckForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="oaWorkFlowCheckForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="oaWorkFlowCheck"/>
    <display:setProperty name="paging.banner.items_name" value="oaWorkFlowChecks"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("oaWorkFlowCheckList");
</script>
