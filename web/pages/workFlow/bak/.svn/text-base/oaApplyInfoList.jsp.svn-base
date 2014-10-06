<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaApplyInfoList.title"/></title>
<content tag="heading"><fmt:message key="oaApplyInfoList.heading"/></content>
<meta name="menu" content="OaApplyInfoMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOaApplyInfo.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="oaApplyInfoList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="oaApplyInfoList" pagesize="25" class="tableDisplay oaApplyInfoList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editOaApplyInfo.html" paramId="id" paramProperty="id"
        titleKey="oaApplyInfoForm.id"/>
    <display:column property="applyStart" sortable="true" headerClass="sortable"
         titleKey="oaApplyInfoForm.applyStart"/>		<!--applyStart--> 
    <display:column property="applyEnd" sortable="true" headerClass="sortable"
         titleKey="oaApplyInfoForm.applyEnd"/>		<!--applyEnd--> 
    <display:column property="checkResultId" sortable="true" headerClass="sortable"
         titleKey="oaApplyInfoForm.checkResultId"/>		<!--checkResultId--> 
    <display:column property="reason" sortable="true" headerClass="sortable"
         titleKey="oaApplyInfoForm.reason"/>		<!--reason--> 
    <display:column property="workFlowTypeId" sortable="true" headerClass="sortable"
         titleKey="oaApplyInfoForm.workFlowTypeId"/>		<!--workFlowTypeId--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="oaApplyInfoForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="oaApplyInfoForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="oaApplyInfoForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="oaApplyInfoForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="oaApplyInfo"/>
    <display:setProperty name="paging.banner.items_name" value="oaApplyInfos"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("oaApplyInfoList");
</script>
