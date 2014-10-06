<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="financeTargetList.title"/></title>
<content tag="heading"><fmt:message key="financeTargetList.heading"/></content>
<meta name="menu" content="FinanceTargetMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editFinanceTarget.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="financeTargetList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="financeTargetList" pagesize="25" class="tableDisplay financeTargetList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editFinanceTarget.html" paramId="id" paramProperty="id"
        titleKey="financeTargetForm.id"/>
    <display:column property="targetDateYear" sortable="true" headerClass="sortable"
         titleKey="financeTargetForm.targetDateYear"/>		<!--targetDateYear--> 
    <display:column property="targetDateMonth" sortable="true" headerClass="sortable"
         titleKey="financeTargetForm.targetDateMonth"/>		<!--targetDateMonth--> 
    <display:column property="targetMoney" sortable="true" headerClass="sortable"
         titleKey="financeTargetForm.targetMoney"/>		<!--targetMoney--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="financeTargetForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="financeTargetForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="financeTargetForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="financeTargetForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="financeTarget"/>
    <display:setProperty name="paging.banner.items_name" value="financeTargets"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("financeTargetList");
</script>
