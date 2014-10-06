<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="incomeModeList.title"/></title>
<content tag="heading"><fmt:message key="incomeModeList.heading"/></content>
<meta name="menu" content="IncomeModeMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editIncomeMode.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="incomeModeList" cellspacing="1" cellpadding="0"
    id="incomeModeList" pagesize="20" class="tableDisplay incomeModeList"
    export="false" requestURI="">
    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editIncomeMode.html" paramId="id" paramProperty="id"
        titleKey="incomeModeForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="incomeModeForm.name"/>
    <display:column property="value" sortable="true" headerClass="sortable"
         titleKey="incomeModeForm.value"/>
    <display:setProperty name="paging.banner.item_name" value="incomeMode"/>
    <display:setProperty name="paging.banner.items_name" value="incomeModes"/>
</display:table>



<script type="text/javascript">
    highlightTableRows("incomeModeList");
</script>
