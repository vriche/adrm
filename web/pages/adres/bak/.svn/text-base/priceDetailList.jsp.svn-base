<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="priceDetailList.title"/></title>
<content tag="heading"><fmt:message key="priceDetailList.heading"/></content>
<meta name="menu" content="PriceDetailMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editPriceDetail.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="priceDetailList" cellspacing="0" cellpadding="0"
    id="priceDetailList" pagesize="25" class="tableDisplay priceDetailList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editPriceDetail.html" paramId="id" paramProperty="id"
        titleKey="priceDetailForm.id"/>
    <display:column property="length" sortable="true" headerClass="sortable"
         titleKey="priceDetailForm.length"/>
    <display:column property="price" sortable="true" headerClass="sortable"
         titleKey="priceDetailForm.price"/>
    <display:setProperty name="paging.banner.item_name" value="priceDetail"/>
    <display:setProperty name="paging.banner.items_name" value="priceDetails"/>
</display:table>

<c:out value="${buttons}" escapeXml="false"/>

<script type="text/javascript">
    highlightTableRows("priceDetailList");
</script>
