<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="incomePurposeList.title"/></title>
<content tag="heading"><fmt:message key="incomePurposeList.heading"/></content>
<meta name="menu" content="IncomePurposeMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editIncomePurpose.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="incomePurposeList" cellspacing="1" cellpadding="0"
    id="incomePurposeList" pagesize="20" class="tableDisplay incomePurposeList"
    export="false" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editIncomePurpose.html" paramId="id" paramProperty="id"
        titleKey="incomePurposeForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="incomePurposeForm.name"/>
    <display:column property="value" sortable="true" headerClass="sortable"
         titleKey="incomePurposeForm.value"/>
    <display:setProperty name="paging.banner.item_name" value="incomePurpose"/>
    <display:setProperty name="paging.banner.items_name" value="incomePurposes"/>
</display:table>


<script type="text/javascript">
    highlightTableRows("incomePurposeList");
</script>
