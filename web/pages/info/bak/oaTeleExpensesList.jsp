<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaTeleExpensesList.title"/></title>
<content tag="heading"><fmt:message key="oaTeleExpensesList.heading"/></content>
<meta name="menu" content="OaTeleExpensesMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOaTeleExpenses.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="oaTeleExpensesList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="oaTeleExpensesList" pagesize="25" class="tableDisplay oaTeleExpensesList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editOaTeleExpenses.html" paramId="id" paramProperty="id"
        titleKey="oaTeleExpensesForm.id"/>
    <display:column property="expenses" sortable="true" headerClass="sortable"
         titleKey="oaTeleExpensesForm.expenses"/>		<!--expenses--> 
    <display:column property="registerDate" sortable="true" headerClass="sortable"
         titleKey="oaTeleExpensesForm.registerDate"/>		<!--registerDate--> 
    <display:column property="branchId" sortable="true" headerClass="sortable"
         titleKey="oaTeleExpensesForm.branchId"/>		<!--branchId--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="oaTeleExpensesForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="oaTeleExpensesForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="oaTeleExpensesForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="oaTeleExpensesForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="oaTeleExpenses"/>
    <display:setProperty name="paging.banner.items_name" value="oaTeleExpensess"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("oaTeleExpensesList");
</script>
