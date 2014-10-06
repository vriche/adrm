<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="contractTargetList.title"/></title>
<content tag="heading"><fmt:message key="contractTargetList.heading"/></content>
<meta name="menu" content="ContractTargetMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editContractTarget.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="contractTargetList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="contractTargetList" pagesize="25" class="tableDisplay contractTargetList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editContractTarget.html" paramId="id" paramProperty="id"
        titleKey="contractTargetForm.id"/>
    <display:column property="carrier.carrierName" sortable="true" headerClass="sortable"
         titleKey="contractTargetForm.carrierId"/>		<!--carrierId--> 
    <display:column property="contract.code" sortable="true" headerClass="sortable"
         titleKey="contractTargetForm.contractId"/>		<!--contractId--> 
    <display:column property="industry.name" sortable="true" headerClass="sortable"
         titleKey="contractTargetForm.industryTypeId"/>		<!--industryTypeId--> 
    <display:column property="target" sortable="true" headerClass="sortable"
         titleKey="contractTargetForm.target"/>		<!--target--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="contractTargetForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="contractTargetForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="contractTargetForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="contractTargetForm.modifyDate"/>		<!--modifyDate--> 
    <display:column property="memo" sortable="true" headerClass="sortable"
         titleKey="contractTargetForm.memo"/>		<!--memo--> 
    <display:setProperty name="paging.banner.item_name" value="contractTarget"/>
    <display:setProperty name="paging.banner.items_name" value="contractTargets"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("contractTargetList");
</script>
