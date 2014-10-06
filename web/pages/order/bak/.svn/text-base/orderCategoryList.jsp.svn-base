<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="orderCategoryList.title"/></title>
<content tag="heading"><fmt:message key="orderCategoryList.heading"/></content>
<meta name="menu" content="OrderCategoryMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOrderCategory.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="orderCategoryList" cellspacing="1" cellpadding="0"
    id="orderCategoryList" pagesize="20" class="tableDisplay ListShort orderCategoryList"
    export="false" requestURI="">

    <display:column property="name" sortable="true" headerClass="sortable"
        url="/editOrderCategory.html" paramId="id" paramProperty="id"
        titleKey="orderCategoryForm.name"/>
    <display:column property="value" sortable="true" headerClass="sortable"
         titleKey="orderCategoryForm.value"/>
    <display:column property="calculateAuto" sortable="true" headerClass="sortable"
         titleKey="orderCategoryForm.calculateAuto"/>
    <display:setProperty name="paging.banner.item_name" value="orderCategory"/>
    <display:setProperty name="paging.banner.items_name" value="orderCategorys"/>
</display:table>


<script type="text/javascript">
    highlightTableRows("orderCategoryList");
</script>
