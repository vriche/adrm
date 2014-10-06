<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="priceList.title"/></title>
<content tag="heading"><fmt:message key="priceList.heading"/></content>
<meta name="menu" content="PriceMenu"/>

<c:set var="buttons">
    <!-- input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editPrice.html"/>'"
        value="<fmt:message key="button.add"/>"/ -->

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="priceList" cellspacing="1" cellpadding="0"
    id="priceList" pagesize="9" class="tableDisplay priceList"
    export="false" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editPrice.html" paramId="id" paramProperty="id"
        titleKey="priceForm.id"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="priceForm.name"/>
    <display:column property="resourceType" sortable="true" headerClass="sortable"
         titleKey="priceForm.resourceType"/>
    <display:column property="resourcePriceType" sortable="true" headerClass="sortable"
         titleKey="priceForm.resourcePriceType"/>
    <display:column property="moneyType" sortable="true" headerClass="sortable"
         titleKey="priceForm.moneyType"/>
    <display:column property="isDefault" sortable="true" headerClass="sortable"
         titleKey="priceForm.isDefault"/>
    <display:column property="isUseRegular" sortable="true" headerClass="sortable"
         titleKey="priceForm.isUseRegular"/>
    <display:setProperty name="paging.banner.item_name" value="price"/>
    <display:setProperty name="paging.banner.items_name" value="prices"/>
</display:table>


<script type="text/javascript">
    highlightTableRows("priceList");
</script>
