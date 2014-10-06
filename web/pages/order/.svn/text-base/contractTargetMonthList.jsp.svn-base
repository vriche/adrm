<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="contractTargetMonthList.title"/></title>
<content tag="heading"><fmt:message key="contractTargetMonthList.heading"/></content>
<meta name="menu" content="ContractTargetMonthMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editContractTargetMonth.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="contractTargetMonthList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="contractTargetMonthList" pagesize="25" class="tableDisplay contractTargetMonthList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editContractTargetMonth.html" paramId="id" paramProperty="id"
        titleKey="contractTargetMonthForm.id"/>
    <display:column property="monthDate" sortable="true" headerClass="sortable"
         titleKey="contractTargetMonthForm.monthDate"/>		<!--monthDate--> 
    <display:column property="monthTarg" sortable="true" headerClass="sortable"
         titleKey="contractTargetMonthForm.monthTarg"/>		<!--monthTarg--> 
    <display:column property="monthReal" sortable="true" headerClass="sortable"
         titleKey="contractTargetMonthForm.monthReal"/>		<!--monthReal--> 
    <display:setProperty name="paging.banner.item_name" value="contractTargetMonth"/>
    <display:setProperty name="paging.banner.items_name" value="contractTargetMonths"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("contractTargetMonthList");
</script>
