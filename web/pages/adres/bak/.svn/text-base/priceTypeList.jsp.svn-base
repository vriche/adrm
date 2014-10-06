<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="priceTypeList.title"/></title>
<content tag="heading"><fmt:message key="priceTypeList.heading"/></content>
<meta name="menu" content="PriceTypeMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editPriceType.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="priceTypeList" cellspacing="1" cellpadding="0"
    id="priceTypeList" pagesize="25" class="tableDisplay priceTypeList"
    export="false" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editPriceType.html" paramId="id" paramProperty="id"
        titleKey="priceTypeForm.id"/>
    <display:column property="priceTypeName" sortable="true" headerClass="sortable"
         titleKey="priceTypeForm.priceTypeName"/>
    <display:column property="value" sortable="true" headerClass="sortable"
         titleKey="priceTypeForm.value"/>
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="priceTypeForm.modifyDate"/>
    <display:column property="enable" sortable="true" headerClass="sortable"
         titleKey="priceTypeForm.enable"/>
    <display:column property="memo" sortable="true" headerClass="sortable"
         titleKey="priceTypeForm.memo"/>
    <display:setProperty name="paging.banner.item_name" value="priceType"/>
    <display:setProperty name="paging.banner.items_name" value="priceTypes"/>
</display:table>


<script type="text/javascript">
    highlightTableRows("priceTypeList");
</script>
