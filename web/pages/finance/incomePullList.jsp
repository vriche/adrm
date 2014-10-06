<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="incomePullList.title"/></title>
<content tag="heading"><fmt:message key="incomePullList.heading"/></content>
<meta name="menu" content="IncomePullMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editIncomePull.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="incomePullList" cellspacing="2" cellpadding="2"
    id="incomePullList" pagesize="9" class="tableDisplay incomePullList"
    export="false" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editIncomePull.html" paramId="id" paramProperty="id"
        titleKey="incomePullForm.id"/>
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="incomePullForm.createBy"/>
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="incomePullForm.createDate"/>
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="incomePullForm.modifyBy"/>
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="incomePullForm.modifyDate"/>
    <display:column property="incomeId" sortable="true" headerClass="sortable"
         titleKey="incomePullForm.incomeId"/>
    <display:column property="resourceCarrierId" sortable="true" headerClass="sortable"
         titleKey="incomePullForm.resourceCarrierId"/>
    <display:column property="moneyPull" sortable="true" headerClass="sortable"
         titleKey="incomePullForm.moneyPull"/>
    <display:column property="moneyIn" sortable="true" headerClass="sortable"
         titleKey="incomePullForm.moneyIn"/>
    <display:setProperty name="paging.banner.item_name" value="incomePull"/>
    <display:setProperty name="paging.banner.items_name" value="incomePulls"/>
</display:table>

<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
    highlightTableRows("incomePullList");
</script>
