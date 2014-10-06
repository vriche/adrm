<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="agentInfoList.title"/></title>
<content tag="heading"><fmt:message key="agentInfoList.heading"/></content>
<meta name="menu" content="AgentInfoMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editAgentInfo.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="agentInfoList" cellspacing="1" cellpadding="0"
    id="agentInfoList" pagesize="25" class="tableDisplay agentInfoList"
    export="false" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editAgentInfo.html" paramId="id" paramProperty="id"
        titleKey="agentInfoForm.id"/>
    <display:column property="agenetType" sortable="true" headerClass="sortable"
         titleKey="agentInfoForm.agenetType"/>
    <display:column property="agentRate" sortable="true" headerClass="sortable"
         titleKey="agentInfoForm.agentRate"/>
    <display:column property="beginDate" sortable="true" headerClass="sortable"
         titleKey="agentInfoForm.beginDate"/>
    <display:column property="customerId" sortable="true" headerClass="sortable"
         titleKey="agentInfoForm.customerId"/>
    <display:column property="endDate" sortable="true" headerClass="sortable"
         titleKey="agentInfoForm.endDate"/>
    <display:column property="industryTypeId" sortable="true" headerClass="sortable"
         titleKey="agentInfoForm.industryTypeId"/>
    <display:column property="state" sortable="true" headerClass="sortable"
         titleKey="agentInfoForm.state"/>
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="agentInfoForm.createBy"/>
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="agentInfoForm.createDate"/>
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="agentInfoForm.modifyBy"/>
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="agentInfoForm.modifyDate"/>
    <display:setProperty name="paging.banner.item_name" value="agentInfo"/>
    <display:setProperty name="paging.banner.items_name" value="agentInfos"/>
</display:table>

<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
    highlightTableRows("agentInfoList");
</script>
