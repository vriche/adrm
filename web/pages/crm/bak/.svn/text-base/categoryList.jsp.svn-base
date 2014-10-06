<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="customerCategoryList.title"/></title>
<content tag="heading"><fmt:message key="customerCategoryList.heading"/></content>
<meta name="menu" content="CategoryMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editCategory.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="categoryList" cellspacing="1" cellpadding="0"
    id="categoryList" pagesize="9" class="tableDisplay categoryList"
    export="false" requestURI="">

    <display:column property="categoryName" sortable="true" headerClass="sortable"
        url="/editCategory.html" paramId="id" paramProperty="id"
        titleKey="customerCategoryForm.categoryName"/>
    <display:column property="categoryCode" sortable="true" headerClass="sortable"
         titleKey="customerCategoryForm.categoryCode"/>
    <display:column property="adResourcePriceType" sortable="true" headerClass="sortable"
         titleKey="customerCategoryForm.adResourcePriceType"/>
    <display:column property="memo" sortable="true" headerClass="sortable"
         titleKey="customerCategoryForm.memo"/>
    <display:setProperty name="paging.banner.item_name" value="category"/>
    <display:setProperty name="paging.banner.items_name" value="categorys"/>
</display:table>



<script type="text/javascript">
    highlightTableRows("categoryList");
</script>
