<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="incomeUsedList.title"/></title>
<content tag="heading"><fmt:message key="incomeUsedList.heading"/></content>
<meta name="menu" content="IncomeUsedMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editIncomeUsed.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="incomeUsedList" cellspacing="0" cellpadding="0"
    id="incomeUsedList" pagesize="25" class="tableDisplay incomeUsedList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editIncomeUsed.html" paramId="id" paramProperty="id"
        titleKey="incomeUsedForm.id"/>
    <display:column property="incomeId" sortable="true" headerClass="sortable"
         titleKey="incomeUsedForm.incomeId"/>
    <display:column property="incomePullId" sortable="true" headerClass="sortable"
         titleKey="incomeUsedForm.incomePullId"/>
    <display:column property="contractId" sortable="true" headerClass="sortable"
         titleKey="incomeUsedForm.contractId"/>
    <display:column property="orderId" sortable="true" headerClass="sortable"
         titleKey="incomeUsedForm.orderId"/>
    <display:column property="orderDetailId" sortable="true" headerClass="sortable"
         titleKey="incomeUsedForm.orderDetailId"/>
    <display:column property="orderDayInfoId" sortable="true" headerClass="sortable"
         titleKey="incomeUsedForm.orderDayInfoId"/>
    <display:column property="publishDate" sortable="true" headerClass="sortable"
         titleKey="incomeUsedForm.publishDate"/>
    <display:column property="moneyIn" sortable="true" headerClass="sortable"
         titleKey="incomeUsedForm.moneyIn"/>
    <display:setProperty name="paging.banner.item_name" value="incomeUsed"/>
    <display:setProperty name="paging.banner.items_name" value="incomeUseds"/>
</display:table>

<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
    highlightTableRows("incomeUsedList");
</script>
