<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="proPublishPlanList.title"/></title>
<content tag="heading"><fmt:message key="proPublishPlanList.heading"/></content>
<meta name="menu" content="ProPublishPlanMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editProPublishPlan.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="proPublishPlanList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="proPublishPlanList" pagesize="25" class="tableDisplay proPublishPlanList"
    export="true" requestURI="">

    <display:column property="carrierId" sortable="true" headerClass="sortable"
         titleKey="proPublishPlanForm.carrierId"/>		<!--carrierId--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="proPublishPlanForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="proPublishPlanForm.createDate"/>		<!--createDate--> 
    <display:column property="endDate" sortable="true" headerClass="sortable"
         titleKey="proPublishPlanForm.endDate"/>		<!--endDate--> 
    <display:column property="endTime" sortable="true" headerClass="sortable"
         titleKey="proPublishPlanForm.endTime"/>		<!--endTime--> 
    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editProPublishPlan.html" paramId="id" paramProperty="id"
        titleKey="proPublishPlanForm.id"/>
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="proPublishPlanForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="proPublishPlanForm.modifyDate"/>		<!--modifyDate--> 
    <display:column property="programId" sortable="true" headerClass="sortable"
         titleKey="proPublishPlanForm.programId"/>		<!--programId--> 
    <display:column property="startDate" sortable="true" headerClass="sortable"
         titleKey="proPublishPlanForm.startDate"/>		<!--startDate--> 
    <display:column property="startTime" sortable="true" headerClass="sortable"
         titleKey="proPublishPlanForm.startTime"/>		<!--startTime--> 
    <display:column property="weeksPlan" sortable="true" headerClass="sortable"
         titleKey="proPublishPlanForm.weeksPlan"/>		<!--weeksPlan--> 
    <display:setProperty name="paging.banner.item_name" value="proPublishPlan"/>
    <display:setProperty name="paging.banner.items_name" value="proPublishPlans"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("proPublishPlanList");
</script>
